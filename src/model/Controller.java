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
	 * Calcule la distance entre deux éléments de l'espace
	 * @param a : le premier élément
	 * @param b : le deuxième élément
	 * @return : la distance entre les deux éléments
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
			
			//Ajouter les produits dans le bon Îlot
			Stock stock = atelier.getStockMP();
			for(Produit p : stock.getProduits()) {
				Operation o = atelier.getGammePdt(p).getOperation(p);
				atelier.getIlot(o).ajoutPdt(p);
			}
			
			for(int i = 0; i < atelier.getNbIlots(); i++) {
				Ilot ilot = atelier.getIlot(i); //Pour chaque îlot
				Produit produit = ilot.getFileAttenteEntree().get(0); //On récupère le premier produit
				Operation operation = ilot.getOperation(); //On récupèré son opération
				
				if(operation.getTempsRealisation() > 0) { //Tant que le produit est en traitement dans sas phase actuelle
					operation.decrementerTempsRealisation();
				} else if(operation.getTempsRealisation() == 0) { //Une fois la phase de traitement du produit terminée
					//Déplacement du produit vers la phase suivante
					produit.phaseSuivante();
					operation = atelier.getGammePdt(produit).getOperation(produit);
					atelier.getIlot(operation).ajoutPdt(produit); //Ajout du produit pour son opération suivante
					ilot.getFileAttenteEntree().remove(produit); //Suppression du produit pour son opération précédebte
				}
				
				if(produit.getNumeroPhase() == atelier.getGammePdt(produit).getListeGamme().size()) { //Une fois le produit totalement traité
					//Toutes les phases ont été réalisées
					produit.fin();
					atelier.addStockPF(produit); //Déplacement du produit dans le stock des produits fini
				}
				
			}
			
			tpsTotalTrait++;
		}
	}
	
	/**
	 * Affiche les résultats de la simulation 
	 */
	public void finSimulation() {
		//Calcul des résultats
		String[] resultGammes = new String[atelier.getNbGammes()];
		int[] result = new int[atelier.getNbGammes()];
		
		List<Produit> produits = atelier.getStockPF().getProduits();
		for(int i = 0; i < produits.size(); i++) {
			Produit p = produits.get(i);
			Gamme gamme = atelier.getGammePdt(p);
			resultGammes[i] = gamme.getNom();
			result[i]++;
		}
		
		//Affichage des résultats
		logger.log(Level.INFO, "Simulation terminée :");
		logger.log(Level.INFO, "Durée : {}", tpsTotalTrait);
		logger.log(Level.INFO, "Pièces fabriquées :");
		for(int i = 0; i < result.length; i++) {
			logger.log(Level.INFO, "{0} éléments fabriqués de {1}", new Object[] {result[i], resultGammes[i]});
		}
		
		logger.log(Level.INFO, "Fin du programme.");
	}
	
	/**
	 * Calcule le temps de déplacement du convoyeur
	 * @param distance : la distance à parcourir
	 * @param vitesse : la vitesse du convoyeur
	 * @return le temps de deplacement
	 */
	public int calculTpsDeplacement(double distance, int vitesse) {
		return (int)(distance/vitesse)+1;
	}
}
