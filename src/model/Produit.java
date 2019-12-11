package model;

/**
 * Un produit est le résultat de différentes transformations représentées par le numéroPhase.
 * @author aserieys
 * Créé le: 05/12/2019
 *
 */
public class Produit {

	private String type;
	private int numeroPhase;
	private boolean fini;
	
	/**
	 * Constructeur de la classe produit
	 * @param type  le type du produit
	 * @param numeroPhase  le numéro de la phase du produit
	 */
	public Produit(String type, int numeroPhase) {
		this.type = type;
		this.numeroPhase = numeroPhase;
		this.fini=false;
	}
	
	/**
	 * Retourne le type du produit
	 * @return String - le type du produit
	 */
	public String getType() {
		return this.type;
	}
	
	/**
	 * Retourne le numéro de la phase du produit
	 * @return int - le numéro de la phase
	 */
	public int getNumeroPhase() {
		return this.numeroPhase;
	}
	
	/**
	 * Met à jour le numéro de la phase du produit
	 */
	public void phaseSuivante() {
		this.numeroPhase++;
	}
	
	/**
	 * Passe le produit à l'état fini
	 */
	public void fin() {
		this.fini=true;
	}
	
	/**
	 * Renvoie l'état du produit
	 * @return true si le produit est fini, false sinon
	 */
	public boolean estFini() {
		return this.fini;
	}
}
