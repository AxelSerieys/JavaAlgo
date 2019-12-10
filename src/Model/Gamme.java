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
	
	/**
	 * Constructeur de la Gamme d'un produit
	 */
	public Gamme() {
		listeGamme = new LinkedList<Operation>();
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

	/** Getter d'une Gamme **/
	public LinkedList<Operation> getListeGamme() {
		return listeGamme;
	}

	/** Setter d'une Gamme **/
	public void setGamme(LinkedList<Operation> listeGamme) {
		this.listeGamme = listeGamme;
	}
}
