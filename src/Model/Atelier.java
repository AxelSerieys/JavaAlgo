package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Atelier contenant une chaine de production
 * @author nathan
 * Créé le: 07/12/2019
 */
public class Atelier {
	
	/** Attribut Atelier: Liste element **/
	Scanner entree = new Scanner(System.in);
	private ArrayList<Ilot> listeIlots;
	private ArrayList<Convoyeur> listeConvoy;
	private ArrayList<Gamme> listeGammes;
	private ArrayList<Operation> listeOperations;
	private Stock stockMP;
	private Stock stockPF;
	private Object [][] tabPdts;
	
	/**
	 * Constructeur d'un Atelier
	 */
	public Atelier() {

	}
	
	/** 
	 * Configuration des îlots de l'atelier et de leur opération 
	 */
	public void configIlots() {
		System.out.println("");
		System.out.println("-- Configuration des îlots");
		System.out.println("");
		System.out.println("Combien d'îlots y a-t'il dans votre atelier?");
		listeIlots=new ArrayList<Ilot>(entree.nextInt());
		for(int i=0; i<listeIlots.size(); i++) {
			System.out.println("Quel est la position en X de l'îlot "+i+"?");
			int ilotX=entree.nextInt();
			System.out.println("Quel est la position en Y de l'îlot "+i+"?");
			int ilotY=entree.nextInt();
			System.out.println("Combien de machines l'îlot "+i+" contient-il?");
			int tailleIlot=entree.nextInt();
			System.out.println("Quel est le type de machines de l'îlot "+i+"?");
			String typeIlot=entree.next();
			System.out.println("Quelle opération cet îlot effectue-t-il?");
			String type = entree.next();
			System.out.println("Quel est son temps de traitement?");
			int tps = entree.nextInt();
			listeOperations.add(new Operation(tps, type));
			TypeMachines m = new TypeMachines(typeIlot);
			listeIlots.add(new Ilot(m, ilotX, ilotY, listeOperations.get(i)));
			for(int j=0; j<tailleIlot; j++) {
				listeIlots.get(i).AjoutMachine(new Machine(m));
			}
		}
	}
	
	/** 
	 * Configuration des convoyeurs de l'atelier 
	 */
	/*public void configConvoy() {
		System.out.println("");
		System.out.println("-- Configuration des convoyeurs");
		System.out.println("");
		System.out.println("Combien de convoyeurs y a-t'il dans votre atelier?");
		listeConvoy=new ArrayList<Convoyeur>(entree.nextInt());
		System.out.println("Quelle est leur vitesse?");
		int vitesse=entree.nextInt();
		//Les convoyeurs sont située au même endroit que le stock de matières premières en debut de simulation
		for (int i=0; i<listeConvoy.size(); i++) {
			listeConvoy.add(new Convoyeur(stockMP.getPositionX(),stockMP.getPositionY(),1,vitesse));
		}
	}*/
	
	/** 
	 * Configuration des stocks de l'atelier 
	 */
	public void configStocks() {
		System.out.println("");
		System.out.println("-- Configuration des stocks");
		System.out.println("");
		//Stock de matières premières
		System.out.println("Quel est la position en X du stock de matières premières?");
		int smpX=entree.nextInt();
		System.out.println("Quel est la position en Y du stock de matières premières?");
		int smpY=entree.nextInt();
		stockMP = new Stock("MP",smpX,smpY);
		
		//Stock de pièces finies
		System.out.println("Quel est la position en X du stock de pièces finies?");
		int spfX=entree.nextInt();
		System.out.println("Quel est la position en Y du stock de pièces finies?");
		int spfY=entree.nextInt();
		stockPF = new Stock("PF",spfX,spfY);
	}
	
	/** 
	 * Configuration des gammes de produits de l'atelier 
	 */
	public void configGammes() {
		System.out.println("");
		System.out.println("-- Configuration des gammes");
		System.out.println("");
		System.out.println("Combien de gammes de produits voulez-vous produire?");
		listeGammes = new ArrayList<Gamme>(entree.nextInt());
		for (int i=0; i<listeGammes.size(); i++) {
			System.out.println("Quel est le nom de la gamme "+i+"?");
			listeGammes.add(new Gamme(entree.next()));
			System.out.println("Quel opération le produit doit-il subir?");
			String choix="y";
			while(choix!="n") {
				System.out.println("Differentes opérations :");
				for(int j=0; j<listeOperations.size(); j++) {
					System.out.println((i+1)+" - "+listeOperations.get(i).getType());
				}
				int choixOp = entree.nextInt();
				Operation operation=null;
				for(int j2=0; j2<listeOperations.size(); j2++) {
					if(choixOp==j2+1) {
						operation=listeOperations.get(j2);
					}
				}
				if(operation==null) {
					System.out.println("Cette opération n'existe pas");
				} else {
					listeGammes.get(i).ajoutPhase(operation);
					System.out.println("Le produit doit-il subir une autre opération? (y/n)");
					choix=entree.next().toLowerCase();
				}
			}
		}
	}
	
	public Object[][] nbProduitsAFabriquer() {
		tabPdts = new Object [listeGammes.size()][2];
		for (int i=0; i<listeGammes.size(); i++) {
			tabPdts[i][0]=listeGammes.get(i).getNom();
			System.out.println("Combien de pièces de la gamme "+listeGammes.get(i).getNom()+" voulez vous produire?");
			tabPdts[i][1]=entree.nextInt();
		}
		return tabPdts;
	}
	
	public void ajoutPdtIlot() {
		Gamme g = getGammePdt(getPdtTopStock());
		int numPhase = getPdtTopStock().getNumeroPhase();
		ajoutPdt(getIlot(g.getListeGamme().get(numPhase)));
		remStockMP(getSizeStockMP()-1);

	}
	
	public void ajoutPdt(Ilot ilot) {
		ilot.ajoutPdt(getPdtTopStock());
	}
	
	public Produit getPdtTopStock() {
		return getStockMP().getProduits().get(getSizeStockMP()-1);
	}
	
	public Ilot getIlot(int i) {
		return listeIlots.get(i);
	}
	
	public Ilot getIlot (Operation op) {
		int j=-1;
		for(int i=0; i<listeIlots.size();i++) {
			if(listeIlots.get(i).getOperation()==op) {
				j = i;
			}
		}
		if(j==-1) {
			System.out.println("Operation inexistante");
		}
		return listeIlots.get(j);
	}
	
	public Gamme getGammePdt(Produit pdt) {
		int j=-1;
		for(int i=0; i<listeGammes.size(); i++) {
			if(listeGammes.get(i).getNom()==pdt.getType()) {
				j = i;
			}
		}
		if(j==-1) {
			System.out.println("Operation inexistante");
		}
		return listeGammes.get(j);
	}
	
	public Gamme getGamme(int i) {
		return listeGammes.get(i);
	}
	
	public int getNbIlots() {
		return listeIlots.size();
	}
	
	/*public Convoyeur getConvoyeur(int i) {
		return listeConvoy.get(i);
	}
	
	public int getNbConvoy() {
		return listeConvoy.size();
	}*/
	
	public int getNbGammes() {
		return listeGammes.size();
	}
	
	public void setStockMP(int pdt, Gamme g) {
		for(int i=0; i<pdt; i++) {
			this.stockMP.addProduit(new Produit(g.getNom(),0));
		}
	}
	
	public void remStockMP(int pdt) {
		this.stockMP.removeProduit(pdt);
	}
	
	public Stock getStockMP() {
		return this.stockMP;
	}
	
	public int getSizeStockMP() {
		return this.stockMP.getProduits().size();
	}
	
	public void addStockPF(Produit pdt) {
		this.stockPF.addProduit(pdt);
	}
	
	public Stock getStockPF() {
		return this.stockPF;
	}
	
	public int getSizeStockPF() {
		return this.stockPF.getProduits().size();
	}
}
