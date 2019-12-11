package Model;

import java.util.LinkedList;

/**
 * Gamme d'un produit 
 * @author nathan 
 * Creer le: 07/12/2019
 */
public class Gamme {
	
	/** Attribut d'une Gamme: Liste Chainee **/
	public static LinkedList<Operation> listeGamme;
	private String nom;
	
	/**
	 * Constructeur de la Gamme d'un produit
	 */
	public Gamme(String nom) {
		listeGamme = new LinkedList<Operation>();
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
		for (int i = 0; i < listeGamme.size(); i++) {
			if (listeGamme.get(i).equals(operation)) {
				listeGamme.remove(i);
			}
		}
	}

	/** 
	 * Getter d'une Gamme
	 * @return une liste contenant les operations de la gamme
	 */
	public LinkedList<Operation> getListeGamme() {
		return listeGamme;
	}

	/** 
	 * Setter d'une Gamme
	 * @param listeGamme: la liste de la Gamme 
	 */
	public void setGamme(LinkedList<Operation> listeGamme) {
		this.listeGamme = listeGamme;
	}
	
	/** 
	 * Getter du nom d'une Gamme 
	 * @return le nom de la gamme
	 */
	public String getNom() {
		return this.nom;
	}
}
