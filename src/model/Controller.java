package model;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller {
	private int tpsTotalTrait=0;
	private Atelier atelier;
	private int nbProduitsFab;
	private Logger logger = Logger.getLogger("logger");
	
	/**
	 * Calcule la distance entre deux �l�ments de l'espace
	 * @param a : le premier �l�ment
	 * @param b : le deuxi�me �l�ment
	 * @return : la distance entre les deux �l�ments
	 */
	public double calculDistance(ElementEspace a, ElementEspace b) {
		return Math.sqrt(Math.pow((double) b.getPositionY()-a.getPositionY(),2)+Math.pow((double)b.getPositionX()-a.getPositionX(),2));
	}
	
	/**
	 * lance la simulation
	 */
	public void lancerSimulation() {
		configurationAtelier();
		configurationProduits();
		simuler();
		finSimulation();
	}
	
	/**
	 * Configure un atelier
	 */
	public void configurationAtelier() {
		atelier=new Atelier();
		atelier.configIlots();
		atelier.configStocks();
		atelier.configGammes();
	}
	
	/**
	 * Configure les produits
	 */
	public void configurationProduits() {
		atelier.nbProduitsAFabriquer();
	}
	
	/**
	 * Simulation
	 */
	public void simuler() {
		for(int i=0; i<atelier.getNbGammes(); i++) {
			nbProduitsFab+=(int)atelier.nbProduitsAFabriquer()[i][1];
			atelier.setStockMP((int)atelier.nbProduitsAFabriquer()[i][1],atelier.getGamme(i));
		}
		while(atelier.getSizeStockPF()<nbProduitsFab) {
			atelier.ajoutPdtIlot();
			
			//Ajouter les produits dans le bon �lot
			Stock stock = atelier.getStockMP();
			for(Produit p : stock.getProduits()) {
				Operation o = atelier.getGammePdt(p).getOperation(p);
				atelier.getIlot(o).ajoutPdt(p);
			}
			
			for(int i = 0; i < atelier.getNbIlots(); i++) {
				Ilot ilot = atelier.getIlot(i); //Pour chaque �lot
				Produit produit = ilot.getFileAttenteEntree().get(0); //On r�cup�re le premier produit
				Operation operation = ilot.getOperation(); //On r�cup�r� son op�ration
				
				if(operation.getTempsRealisation() > 0) { //Tant que le produit est en traitement dans sas phase actuelle
					operation.decrementerTempsRealisation();
				} else if(operation.getTempsRealisation() == 0) { //Une fois la phase de traitement du produit termin�e
					//D�placement du produit vers la phase suivante
					produit.phaseSuivante();
					operation = atelier.getGammePdt(produit).getOperation(produit);
					atelier.getIlot(operation).ajoutPdt(produit); //Ajout du produit pour son op�ration suivante
					ilot.getFileAttenteEntree().remove(produit); //Suppression du produit pour son op�ration pr�c�debte
				}
				
				if(produit.getNumeroPhase() == atelier.getGammePdt(produit).getListeGamme().size()) { //Une fois le produit totalement trait�
					//Toutes les phases ont �t� r�alis�es
					produit.fin();
					atelier.addStockPF(produit); //D�placement du produit dans le stock des produits fini
				}
				
			}
			
			tpsTotalTrait++;
		}
	}
	
	/**
	 * Affiche les r�sultats de la simulation 
	 */
	public void finSimulation() {
		//Calcul des r�sultats
		String[] resultGammes = new String[atelier.getNbGammes()];
		int[] result = new int[atelier.getNbGammes()];
		
		List<Produit> produits = atelier.getStockPF().getProduits();
		for(int i = 0; i < produits.size(); i++) {
			Produit p = produits.get(i);
			Gamme gamme = atelier.getGammePdt(p);
			resultGammes[i] = gamme.getNom();
			result[i]++;
		}
		
		//Affichage des r�sultats
		logger.log(Level.INFO, "Simulation termin�e :");
		logger.log(Level.INFO, "Dur�e : {}", tpsTotalTrait);
		logger.log(Level.INFO, "Pi�ces fabriqu�es :");
		for(int i = 0; i < result.length; i++) {
			logger.log(Level.INFO, "{0} �l�ments fabriqu�s de {1}", new Object[] {result[i], resultGammes[i]});
		}
		
		logger.log(Level.INFO, "Fin du programme.");
	}
	
	/**
	 * Calcule le temps de d�placement du convoyeur
	 * @param distance : la distance � parcourir
	 * @param vitesse : la vitesse du convoyeur
	 * @return le temps de deplacement
	 */
	public int calculTpsDeplacement(double distance, int vitesse) {
		return (int)(distance/vitesse)+1;
	}
}
