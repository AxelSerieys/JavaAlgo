package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Un stock permet de stocker plusieurs produits
 * @author aserieys
 *
 */
public class Stock extends ElementEspace{

	private String type;
	private List<Produit> produits;
	
	public Stock(String type, int x, int y) {
		super(x,y);
		this.type = type;
		this.produits = new ArrayList<Produit>();
	}
	
	@Deprecated
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}
	
	/**
	 * Ajoute un produit dans le stock
	 * @param produit : le produit à ajouter
	 */
	public void addProduit(Produit produit) {
		produits.add(produit);
	}
	
	/**
	 * Enlève un produit du stock
	 * @param produit : le produit à enlever
	 */
	public void removeProduit(Produit produit) {
		produits.remove(produit);
	}
	
	/**
	 * Enlève un produit du stock
	 * @param index : l'index du produit à enlever dans la liste
	 */
	public void removeProduit(int index) {
		produits.remove(index);
	}
}
