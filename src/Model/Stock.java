package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Un stock permet de stocker plusieurs produits
 * @author aserieys
 * Créé le: 05/12/2019
 *
 */
public class Stock extends ElementEspace{

	private String type;
	private List<Produit> produits;
	
	/**
	 * Constructeur de la classe Stock
	 * @param type  le type du stock
	 * @param x  la position en x du stock
	 * @param y  la position en y du stock
	 */
	public Stock(String type, int x, int y) {
		super(x,y);
		this.type = type;
		this.produits = new ArrayList<Produit>();
	}
	
	
	/**
	 * Retourne le type du stock
	 * @return String - le type du stock
	 */
	public String getType() {
		return this.type;
	}
	
	/**
	 * Ajoute un produit dans le stock
	 * @param produit  le produit à ajouter
	 */
	public void addProduit(Produit produit) {
		produits.add(produit);
	}
	
	/**
	 * Enlève un produit du stock
	 * @param produit  le produit à enlever
	 */
	public void removeProduit(Produit produit) {
		produits.remove(produit);
	}
	
	/**
	 * Enlève un produit du stock
	 * @param index  l'index du produit à enlever dans la liste
	 */
	public void removeProduit(int index) {
		produits.remove(index);
	}
	
	/**
	 * Retourne la liste des produits dans le stock
	 * @return List<Produit> la liste des produits dans le stock
	 */
	public List<Produit> getProduits() {
		return this.produits;
	}
}
