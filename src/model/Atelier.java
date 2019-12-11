package model;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import java.util.Scanner;

/**
 * Atelier contenant une chaine de production
 * @author nathan
 * Cr�� le: 07/12/2019
 */
public class Atelier {
	
	/** Attribut Atelier: Liste element **/
	private Scanner entree = new Scanner(System.in);
	private ArrayList<Ilot> listeIlots;
	private ArrayList<Gamme> listeGammes;
	private ArrayList<Operation> listeOperations;
	private Stock stockMP;
	private Stock stockPF;
	private Logger logger = Logger.getLogger("logger");
	
	/** 
	 * Configuration des �lots de l'atelier et de leur op�ration 
	 */
	public void configIlots() {
		logger.log(Level.INFO, "");
		logger.log(Level.INFO, "-- Configuration des �lots");
		logger.log(Level.INFO, "");
		logger.log(Level.INFO, "Combien d'�lots y a-t'il dans votre atelier?");
		listeIlots=new ArrayList<>(entree.nextInt());
		for(int i=0; i<listeIlots.size(); i++) {
			logger.log(Level.INFO, "Quelle est la position en X de l''�lot {}?", i);
			int ilotX=entree.nextInt();
			logger.log(Level.INFO, "Quelle est la position en Y de l''�lot {}?", i);
			int ilotY=entree.nextInt();
			logger.log(Level.INFO, "Combien de machines l''�lot {} contient-il?", i);
			int tailleIlot=entree.nextInt();
			logger.log(Level.INFO, "Quel est le type de machines de ''�lot {}?", i);
			String typeIlot=entree.next();
			logger.log(Level.INFO, "Quelle op�ration cet �lot effectue-t-il?");
			String type = entree.next();
			logger.log(Level.INFO, "Quel est son temps de traitement?");
			int tps = entree.nextInt();
			listeOperations.add(new Operation(tps, type));
			TypeMachines m = new TypeMachines(typeIlot);
			listeIlots.add(new Ilot(m, ilotX, ilotY, listeOperations.get(i)));
			for(int j=0; j<tailleIlot; j++) {
				listeIlots.get(i).ajoutMachine(new Machine(m));
			}
		}
	}
	
	/** 
	 * Configuration des stocks de l'atelier 
	 */
	public void configStocks() {
		logger.log(Level.INFO, "");
		logger.log(Level.INFO, "-- Configuration des stocks");
		logger.log(Level.INFO, "");
		//Stock de mati�res premi�res
		logger.log(Level.INFO, "Quel est la position en X du stock de mati�res premi�res?");
		int smpX=entree.nextInt();
		logger.log(Level.INFO, "Quel est la position en Y du stock de mati�res premi�res?");
		int smpY=entree.nextInt();
		stockMP = new Stock("MP",smpX,smpY);
		
		//Stock de pi�ces finies
		logger.log(Level.INFO, "Quel est la position en X du stock de pi�ces finies?");
		int spfX=entree.nextInt();
		logger.log(Level.INFO, "Quel est la position en Y du stock de pi�ces finies?");
		int spfY=entree.nextInt();
		stockPF = new Stock("PF",spfX,spfY);
	}
	
	/** 
	 * Configuration des gammes de produits de l'atelier 
	 */
	public void configGammes() {
		logger.log(Level.INFO, "");
		logger.log(Level.INFO, "-- Configuration des gammes");
		logger.log(Level.INFO, "");
		logger.log(Level.INFO, "Combien de gammes de produits voulez-vous produire?");
		listeGammes = new ArrayList<>(entree.nextInt());
		for (int i=0; i<listeGammes.size(); i++) {
			logger.log(Level.INFO, "Quel est le nom de la gamme {}?", i);
			listeGammes.add(new Gamme(entree.next()));
			logger.log(Level.INFO, "Quel op�ration le produit doit-il subir?");
			String choix="y";
			while(!choix.equals("n")) {
				logger.log(Level.INFO, "Differentes op�rations :");
				for(int j=0; j<listeOperations.size(); j++) {
					logger.log(Level.INFO, "{0} - {1}", new Object[] {(i+1), listeOperations.get(i).getType()});
				}
				int choixOp = entree.nextInt();
				Operation operation=null;
				for(int j2=0; j2<listeOperations.size(); j2++) {
					if(choixOp==j2+1) {
						operation=listeOperations.get(j2);
					}
				}
				if(operation==null) {
					logger.log(Level.INFO, "Cette op�ration n'existe pas");
				} else {
					listeGammes.get(i).ajoutPhase(operation);
					logger.log(Level.INFO, "Le produit doit-il subir une autre op�ration? (y/n)");
					choix=entree.next().toLowerCase();
				}
			}
		}
	}
	
	/**
	 * Liste des produits � fabriquer
	 * @return Object[][] nom de la gamme, nombre de produits dans cette gamme
	 */
	public Object[][] nbProduitsAFabriquer() { //Nom de la gamme, nbre de produit de cette gamme
		Object[][] tabPdts;
		tabPdts = new Object [listeGammes.size()][2];
		for (int i=0; i<listeGammes.size(); i++) {
			tabPdts[i][0]=listeGammes.get(i).getNom();
			logger.log(Level.INFO, "Combien de pi�ces de la gamme "+listeGammes.get(i).getNom()+" voulez vous produire?");
			tabPdts[i][1]=entree.nextInt();
		}
		return tabPdts;
	}
	
	/**
	 * Renvoie le temps de traitement d'une pi�ce dans un �lot donn�
	 * @param ilot l'�lot dont la dur�e sera renvoy�e
	 * @return la dur�e de traitement d'une pi�ce dans un �lot
	 */
	public int tpsTraitementPiece(Ilot ilot) {
		return ilot.getOperation().getTempsRealisation();
	}
	
	/**
	 * Ajoute des produits dans l'�lot
	 */
	public void ajoutPdtIlot() {
		Gamme g = getGammePdt(getPdtTopStock());
		int numPhase = getPdtTopStock().getNumeroPhase();
		ajoutPdt(getIlot(g.getListeGamme().get(numPhase)));
		remStockMP(getSizeStockMP()-1);

	}
	
	/**
	 * Ajoute des produits dans un �lot donn�
	 * @param ilot
	 */
	public void ajoutPdt(Ilot ilot) {
		ilot.ajoutPdt(getPdtTopStock());
	}
	
	/**
	 * Retourne le premier �l�ment du stock de mati�res premi�res
	 * @return Produit le premier �l�ment de la liste
	 */
	public Produit getPdtTopStock() {
		List<Produit> list = getStockMP().getProduits();
		return list.get(getSizeStockMP()-1);
	}
	
	/**
	 * Retourne le premier �lot dont le typeMachine est �quivalent � celui pass� en param�tre
	 * @param type le type des machines
	 * @return un �lot
	 */
	public Ilot getIlot(String type) {
		for(Ilot i : listeIlots)
			if(i.getType().equals(type))
				return i;
		
		return null;
	}
	
	/**
	 * Retourne une �lot � un index donn�
	 * @param i l'index de l'ilot
	 * @return l'�lot � l'index donn�
	 */
	public Ilot getIlot(int i) {
		return listeIlots.get(i);
	}
	
	/**
	 * Retourne l'ilot dont l'op�ration est pass�e en param�tre
	 * @param op l'op�ration
	 * @return l'ilot dont l'op�ration est pass�e en param�tre
	 */
	public Ilot getIlot (Operation op) {
		int j=-1;
		for(int i=0; i<listeIlots.size();i++) {
			if(listeIlots.get(i).getOperation()==op) {
				j = i;
			}
		}
		if(j==-1) {
			logger.log(Level.INFO, "Operation inexistante");
		}
		return listeIlots.get(j);
	}
	
	/**
	 * Retourne la gamme d'un produit donn�
	 * @param pdt le produit
	 * @return Gamme , sa gamme
	 */
	public Gamme getGammePdt(Produit pdt) {
		int j=-1;
		for(int i=0; i<listeGammes.size(); i++) {
			if(listeGammes.get(i).getNom().equals(pdt.getType())) {
				j = i;
			}
		}
		if(j==-1) {
			logger.log(Level.INFO, "Operation inexistante");
		}
		return listeGammes.get(j);
	}
	
	/**
	 * Retourne la gamme � un indice donn� dans la liste de gammes interne � l'atelier
	 * @param i l'indice de la game
	 * @return Gamme, la gamme � l'indice donn�
	 */
	public Gamme getGamme(int i) {
		return listeGammes.get(i);
	}
	
	/**
	 * Retourne le nombre d'�lots dans l'atelier
	 * @return int le nombre d'�lots
	 */
	public int getNbIlots() {
		return listeIlots.size();
	}
	
	/**
	 * Retourne le nombre de gammes
	 * @return int le nombre de gammes
	 */
	public int getNbGammes() {
		return listeGammes.size();
	}
	
	/**
	 * Ajoute des produits dans le stock des mati�res premi�res
	 * @param pdt : le nomnre de produits � ajouter
	 * @param g la gamme dont les produits seront ajout�s
	 */
	public void setStockMP(int pdt, Gamme g) {
		for(int i=0; i<pdt; i++) {
			this.stockMP.addProduit(new Produit(g.getNom(),0));
		}
	}
	
	/**
	 * Enl�ve un produit du stock de mati�res premieres
	 * @param pdt l'indice du produit dans le stock de mati�res premi�res
	 */
	public void remStockMP(int pdt) {
		this.stockMP.removeProduit(pdt);
	}
	
	/**
	 * Retourne le stock de mati�res premi�res
	 * @return Stock, le stock de mati�res premi�res
	 */
	public Stock getStockMP() {
		return this.stockMP;
	}
	
	/**
	 * Retourne la taille du stock de mati�res premi�res
	 * @return int la taille du stock
	 */
	public int getSizeStockMP() {
		return this.stockMP.getProduits().size();
	}
	
	/**
	 * Ajoute un produit dans le stock des produits finis
	 * @param pdt le produit � ajouter
	 */
	public void addStockPF(Produit pdt) {
		this.stockPF.addProduit(pdt);
	}
	
	/**
	 * Retourne le stock des produits finis
	 * @return Stock, le stock des produits finis
	 */
	public Stock getStockPF() {
		return this.stockPF;
	}
	
	/**
	 * Retourne la taille du stock des produits finis
	 * @return la taille du stock
	 */
	public int getSizeStockPF() {
		return this.stockPF.getProduits().size();
	}
}
