package Model;

/**
 * Un convoyeur transporte des produits aux différents Îlots
 * @author aserieys
 *
 */
public class Convoyeur {
	
	private int vitesseDeplacement;
	private int capacite;
	private String type;
	private Produit produit = null;
	
	public Convoyeur(String type, int capacite, int vitesseDeplacement) {
		this.type = type;
		this.capacite = capacite;
		this.vitesseDeplacement = vitesseDeplacement;
	}
	
	public String getType() {
		return this.type;
	}
	
	public int getCapacite() {
		return this.capacite;
	}
	
	public int getVitesseDeplacement() {
		return this.vitesseDeplacement;
	}
	
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	
	public Produit getProduit() {
		return this.produit;
	}
	
	@Deprecated
	public void setType(String type) {
		this.type = type;
	}
	
	@Deprecated
	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	
	@Deprecated
	public void setVitesseDeplacement(int vitesseDeplacement) {
		this.vitesseDeplacement = vitesseDeplacement;
	}

}
