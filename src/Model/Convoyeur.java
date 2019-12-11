package Model;

/**
 * Un convoyeur transporte des produits aux diff�rents �lots
 * @author aserieys
 * Cr�� le: 05/12/2019
 *
 */
public class Convoyeur extends ElementEspace{
	
	private int vitesseDeplacement;
	private int capacite;
	private Produit produit = null;
	private boolean deplacement;
	
	/**
	 * Constructeur de Convoyeur :
	 * @param x la position en x du convoyeur
	 * @param y la position en y du convoyeur
	 * @param capacite la capacit� de stockage du convoyeur
	 * @param vitesseDeplacement la vitesse de d�placement du convoyeur
	 */
	public Convoyeur(int x, int y, int capacite, int vitesseDeplacement) {
		super(x,y);
		this.capacite = capacite;
		this.vitesseDeplacement = vitesseDeplacement;
		this.deplacement=false;
	}
	
	/**
	 * Retourne la capacit� de stockage du convoyeur
	 * @return int - la capacit� de stockage du convoyeur
	 */
	public int getCapacite() {
		return this.capacite;
	}
	
	/**
	 * Retourne la vitesse de d�placement du convoyeur
	 * @return int - la vitesse de d�placement du convoyeur
	 */
	public int getVitesseDeplacement() {
		return this.vitesseDeplacement;
	}
	
	/**
	 * Fixe le produit � transporter par le convoyeur
	 * @param produit  le produit � transporter
	 */
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	
	/**
	 * Retourne le produit qui est transport� par le convoyeur
	 * @return Produit - le produit transport�
	 */
	public Produit getProduit() {
		return this.produit;
	}
	
	public void setDeplacement(boolean b) {
		this.deplacement=b;
	}
	
	public boolean getDeplacement() {
		return this.deplacement;
	}

	/**
	 * Change la capacit� du convoyeur
	 * @param capacite  la nouvelle capacit� du convoyeur
	 */
	@Deprecated
	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	
	/**
	 * Change la vitesse de d�placement du convoyeur
	 * @param vitesseDeplacement  sa nouvelle vitese de d�placement
	 */
	@Deprecated
	public void setVitesseDeplacement(int vitesseDeplacement) {
		this.vitesseDeplacement = vitesseDeplacement;
	}

}
