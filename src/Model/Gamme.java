package Model;

import java.util.LinkedList;

/**
 * Gamme d'un produit 
 * @author nathan 
 * Creer le: 07/12/2019
 */
public class Gamme {
	
	/** Attribut d'une Gamme: Liste Chainee **/
	private LinkedList<Operation> listeGamme;

	/** Getter d'une Gamme **/
	public LinkedList<Operation> getListeGamme() {
		return listeGamme;
	}

	/** Setter d'une Gamme **/
	public void setGamme(LinkedList<Operation> listeGamme) {
		this.listeGamme = listeGamme;
	}
	
	

}
