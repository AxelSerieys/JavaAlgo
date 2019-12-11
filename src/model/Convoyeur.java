package model;

/**
 * Un convoyeur transporte des produits aux différents Îlots
 * @author aserieys
 * Créé le: 05/12/2019
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
	 * @param capacite la capacité de stockage du convoyeur
	 * @param vitesseDeplacement la vitesse de déplacement du convoyeur
	 */
	public Convoyeur(int x, int y, int capacite, int vitesseDeplacement) {
		super(x,y);
		this.capacite = capacite;
		this.vitesseDeplacement = vitesseDeplacement;
		this.deplacement=false;
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
	 * libere le produit à transporter par le convoyeur
	 * @param produit  le produit à transporter
	 */
	public void dropProduit() {
		this.produit = null;
	}
	
	/**
	 * Retourne le produit qui est transporté par le convoyeur
	 * @return Produit - le produit transporté
	 */
	public Produit getProduit() {
		return this.produit;
	}
	
	/**
	 * Déclare le convoyeur en déplacement ou non en fonction du paramètre
	 * @param b : la valeur bolléenne du déplacement
	 */
	public void setDeplacement(boolean b) {
		this.deplacement=b;
	}
	
	/**
	 * Retourne true si le convoyeur est en déplacement, sinon false
	 * @return boolean, la valeur booléenne du déplacement
	 */
	public boolean getDeplacement() {
		return this.deplacement;
	}

}
