package Model;

/**
 * Un produit est le résultat de différentes transformations représentées par le numéroPhase.
 * @author aserieys
 *
 */
public class Produit {

	private String type;
	private int numeroPhase;
	
	public String getType() {
		return this.type;
	}
	
	public int getNumeroPhase() {
		return this.numeroPhase;
	}
	
	public void setNumeroPhase(int numeroPhase) {
		this.numeroPhase = numeroPhase;
	}
}
