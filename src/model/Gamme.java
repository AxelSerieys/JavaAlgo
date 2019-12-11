package model;

import java.util.LinkedList;
import java.util.List;

/**
 * Gamme d'un produit 
 * @author nathan 
 * Creer le: 07/12/2019
 */
public class Gamme {
	
	/** Attribut d'une Gamme: Liste Chainee **/
	private static List<Operation> listeGamme = new LinkedList<>();
	private String nom;
	
	/**
	 * Constructeur de la Gamme d'un produit
	 */
	public Gamme(String nom) {
		this.nom=nom;
	}
	
	/**
	 * Ajoute une Phase/Operation à la gamme (les uns à la suite des autres)
	 * @param operation: operation à ajouter à la gamme
	 */
	public void ajoutPhase(Operation operation) {
		listeGamme.add(operation);
	}
	
	/**
	 *  Ajoute une phase/operation entre deux phases
	 * @param position: position ou l'on souhaite placer la nouvelle operation
	 * @param operation: operation que l'on souhaite ajouter
	 */
	public void ajoutEntrePhase(int position, Operation operation) {
		listeGamme.add(position-1, operation);
	}
	
	/**
	 * Phase/operation que l'on souhaite supprimer de la gamme
	 * @param operation
	 */
	public void supprPhase(Operation operation) {
		int index = -1;
		for (int i = 0; i < listeGamme.size(); i++) {
			if (listeGamme.get(i).equals(operation)) {
				index = i;
			}
		}
		
		listeGamme.remove(index);
	}

	/** 
	 * Getter d'une Gamme
	 * @return une liste contenant les operations de la gamme
	 */
	public List<Operation> getListeGamme() {
		return listeGamme;
	}
	
	/**
	 * Retourne l'opération d'un produit donné
	 * @param p le produit
	 * @return Operation, l'opération du produit
	 */
	public Operation getOperation(Produit p) {
		return listeGamme.get(p.getNumeroPhase());
	}

	/** 
	 * Setter d'une Gamme
	 * @param listeGamme: la liste de la Gamme 
	 */
	public static void setGamme(List<Operation> listeGamme) {
		Gamme.listeGamme = listeGamme;
	}
	
	/** 
	 * Getter du nom d'une Gamme 
	 * @return le nom de la gamme
	 */
	public String getNom() {
		return this.nom;
	}
}
