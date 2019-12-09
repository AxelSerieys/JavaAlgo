package Model;

/**
 * Un produit est le résultat de différentes transformations représentées par le numéroPhase.
 * @author aserieys
 *
 */
public class Produit {

	private String type;
	private int numeroPhase;
	
	/**
	 * Constructeur de la classe produit
	 * @param type  le type du produit
	 * @param numeroPhase  le numéro de la phase du produit
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
	 * Retourne le numéro de la phase du produit
	 * @return int - le numéro de la phase
	 */
	public int getNumeroPhase() {
		return this.numeroPhase;
	}
	
	/**
	 * Met à jour le numéro de la phase du produit
	 * @param numeroPhase  la nouvelle phase du produit
	 */
	public void setNumeroPhase(int numeroPhase) {
		this.numeroPhase = numeroPhase;
	}
}
