package Model;

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
