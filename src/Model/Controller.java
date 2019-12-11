package Model;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
	private int tpsTotalTrait=0;
	Scanner entree = new Scanner(System.in);
	private Atelier atelier;
	private int nbProduitsFab;
	
	public double calculDistance(ElementEspace a, ElementEspace b) {
		return Math.sqrt(Math.pow(b.getPositionY()-a.getPositionY(),2)+Math.pow(b.getPositionX()-a.getPositionX(),2));
	}
	
	public void lancerSimulation() {
		configurationAtelier();
		configurationProduits();
		simuler();
	}
	
	public void configurationAtelier() {
		atelier=new Atelier();
		atelier.configIlots();
		atelier.configStocks();
		atelier.configGammes();
	}
	
	public void configurationProduits() {
		atelier.nbProduitsAFabriquer();
	}
	
	public void simuler() {
		for(int i=0; i<atelier.getNbGammes(); i++) {
			nbProduitsFab+=(int)atelier.nbProduitsAFabriquer()[i][1];
			atelier.setStockMP((int)atelier.nbProduitsAFabriquer()[i][1],atelier.getGamme(i));
		}
		while(atelier.getSizeStockPF()<nbProduitsFab) {
			
			atelier.ajoutPdtIlot();
			
			tpsTotalTrait++;
		}
	}
	
	public int calculTpsDeplacement(double distance, int vitesse) {
		return (int)(distance/vitesse)+1;
	}
}
