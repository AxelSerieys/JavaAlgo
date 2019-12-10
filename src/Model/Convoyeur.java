package Model;

/**
 * Un convoyeur transporte des produits aux différents Îlots
 * @author aserieys
 * Créé le: 05/12/2019
 *
 */
public class Convoyeur extends ElementEspace{
	
	private int vitesseDeplacement;
	private int capacite;
	private String type;
	private Produit produit = null;
	
	/**
	 * Constructeur de Convoyeur :
	 * @param x la position en x du convoyeur
	 * @param y la position en y du convoyeur
	 * @param type le type du convoyeur
	 * @param capacite la capacité de stockage du convoyeur
	 * @param vitesseDeplacement la vitesse de déplacement du convoyeur
	 */
	public Convoyeur(int x, int y, String type, int capacite, int vitesseDeplacement) {
		super(x,y);
		this.type = type;
		this.capacite = capacite;
		this.vitesseDeplacement = vitesseDeplacement;
	}
	
	/**
	 * Retourne le type du convoyeur
	 * @return String - le type du convoyeur
	 */
	public String getType() {
		return this.type;
	}
	
	/**
	 * Retourne la capacité de stockage du convoyeur
	 * @return int - la capacité de stockage du convoyeur
	 */
	public int getCapacite() {
		return this.capacite;
	}
	
	/**
	 * Retourne la vitesse de déplacement du convoyeur
	 * @return int - la vitesse de déplacement du convoyeur
	 */
	public int getVitesseDeplacement() {
		return this.vitesseDeplacement;
	}
	
	/**
	 * Fixe le produit à transporter par le convoyeur
	 * @param produit  le produit à transporter
	 */
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	
	/**
	 * Retourne le produit qui est transporté par le convoyeur
	 * @return Produit - le produit transporté
	 */
	public Produit getProduit() {
		return this.produit;
	}
	
	/**
	 * Change le type du convoyeur
	 * @param type  le nouveau type du convoyeur
	 */
	@Deprecated
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Change la capacité du convoyeur
	 * @param capacite  la nouvelle capacité du convoyeur
	 */
	@Deprecated
	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	
	/**
	 * Change la vitesse de déplacement du convoyeur
	 * @param vitesseDeplacement  sa nouvelle vitese de déplacement
	 */
	@Deprecated
	public void setVitesseDeplacement(int vitesseDeplacement) {
		this.vitesseDeplacement = vitesseDeplacement;
	}

}
