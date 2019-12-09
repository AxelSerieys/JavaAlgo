package Model;

/**
 * Un produit est le r�sultat de diff�rentes transformations repr�sent�es par le num�roPhase.
 * @author aserieys
 *
 */
public class Produit {

	private String type;
	private int numeroPhase;
	
	/**
	 * Constructeur de la classe produit
	 * @param type  le type du produit
	 * @param numeroPhase  le num�ro de la phase du produit
	 */
	public Produit(String type, int numeroPhase) {
		this.type = type;
		this.numeroPhase = numeroPhase;
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
	 * @param numeroPhase  la nouvelle phase du produit
	 */
	public void setNumeroPhase(int numeroPhase) {
		this.numeroPhase = numeroPhase;
	}
}
