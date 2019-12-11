package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Operation � effectuer sur un Produit
 * @author nathan
 * Creer le: 07/12/2019
 */
public class Operation {

	/** Attribut d'une Operation: temps de r�alisation de l'Operation **/
	private int tempsRealisation;
	
	/** Attribut d'une Operation: type d'Operation **/
	private String type;
	
	/** Liste des operations **/
	private static List<Operation> listeOperation =  new ArrayList<>();
	
	/**
	 * Constructeur Operation
	 * @param tpsRealisation: temps de realisation d'une operation
	 * @param type: type d'operation
	 */
	public Operation(int tpsRealisation, String type) {
		this.tempsRealisation = tpsRealisation;
		this.type = type;
	}
	
	public static List<Operation> getListOperation() {
		return Operation.listeOperation;
	}
	
	/**
	 * Ajoute une operation aux operation possible d'effectuer
	 * @param operation: operation a ajouter dans la liste
	 */
	public static void ajoutOperation(Operation operation) {
		listeOperation.add(operation);
	}
	
	/**
	 * Supprime une operation
	 * @param operation: operation � supprimer
	 */
	public static void supprOperation(Operation operation) {
		int toRemove = -1;
		for (int i = 0; i < listeOperation.size(); i++) {
			if (listeOperation.get(i).equals(operation)) {
				toRemove = i;
			}
		}
		
		listeOperation.remove(toRemove);
	}
	
	/**
	 * Affiche la liste des operations
	 * @return la liste des operations
	 */
	public List<Operation> afficheListeOperation() {
		return listeOperation;
		
	}
	
	/**
	 * D�cr�mente le temps de r�alisation restant pour une op�ration
	 */
	public void decrementerTempsRealisation() {
		this.tempsRealisation--;
	}

	/** Getter temps de r�alisation d'une Operation **/
	public int getTempsRealisation() {
		return tempsRealisation;
	}

	/** Setter temps de r�alisation d'une Operation **/
	public void setTempsRealisation(int tempsRealisation) {
		this.tempsRealisation = tempsRealisation;
	}

	/** Setter du type d'une Operation **/
	public String getType() {
		return type;
	}

	/** Setter du type d'une Operation **/
	public void setType(String type) {
		this.type = type;
	}
}
