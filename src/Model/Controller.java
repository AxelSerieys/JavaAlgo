package Model;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
	private int tpsTotalTrait=0;
	Scanner entree = new Scanner(System.in);
	private Atelier atelier;
	
	public double calculDistance(ElementEspace a, ElementEspace b) {
		return Math.sqrt(Math.pow(b.getPositionY()-a.getPositionY(),2)+Math.pow(b.getPositionX()-a.getPositionX(),2));
	}
	
	public void lancerSimulation() {
		configurationAtelier();
		simuler();
	}
	
	public void configurationAtelier() {
		atelier=new Atelier();
		atelier.configIlots();
		atelier.configConvoy();
		atelier.configStocks();
		atelier.configOperations();
		atelier.configGammes();
	}
	
	public void configurationProduits() {
		
	}
	
	public void simuler() {
		//while(nb produit dans le stock final<nb produits a fabriquer)
	}
	
	public double calculTpsDeplacement(double distance, int vitesse) {
		return (distance/vitesse);
	}
}
