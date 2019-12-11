package model;

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
	 * libere le produit � transporter par le convoyeur
	 * @param produit  le produit � transporter
	 */
	public void dropProduit() {
		this.produit = null;
	}
	
	/**
	 * Retourne le produit qui est transport� par le convoyeur
	 * @return Produit - le produit transport�
	 */
	public Produit getProduit() {
		return this.produit;
	}
	
	/**
	 * D�clare le convoyeur en d�placement ou non en fonction du param�tre
	 * @param b : la valeur boll�enne du d�placement
	 */
	public void setDeplacement(boolean b) {
		this.deplacement=b;
	}
	
	/**
	 * Retourne true si le convoyeur est en d�placement, sinon false
	 * @return boolean, la valeur bool�enne du d�placement
	 */
	public boolean getDeplacement() {
		return this.deplacement;
	}

}
