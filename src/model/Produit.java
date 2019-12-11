package model;

/**
 * Un produit est le r�sultat de diff�rentes transformations repr�sent�es par le num�roPhase.
 * @author aserieys
 * Cr�� le: 05/12/2019
 *
 */
public class Produit {

	private String type;
	private int numeroPhase;
	private boolean fini;
	
	/**
	 * Constructeur de la classe produit
	 * @param type  le type du produit
	 * @param numeroPhase  le num�ro de la phase du produit
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
	 * Retourne le num�ro de la phase du produit
	 * @return int - le num�ro de la phase
	 */
	public int getNumeroPhase() {
		return this.numeroPhase;
	}
	
	/**
	 * Met � jour le num�ro de la phase du produit
	 */
	public void phaseSuivante() {
		this.numeroPhase++;
	}
	
	/**
	 * Passe le produit � l'�tat fini
	 */
	public void fin() {
		this.fini=true;
	}
	
	/**
	 * Renvoie l'�tat du produit
	 * @return true si le produit est fini, false sinon
	 */
	public boolean estFini() {
		return this.fini;
	}
}
