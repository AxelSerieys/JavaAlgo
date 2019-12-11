package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Produit;
import model.Stock;

class StockTest {
	
	private static final String PRODUIT1="produit1";

	/**
	 * On teste la création d'un stock
	 */
	@Test
	void testCreationStock() {
		int x = 1;
		int y = 2;
		String type = "final";
		Stock stock = new Stock(type, x, y);
		
		assertNotEquals(null, stock);
	}
	
	/**
	 * On vérifie que le type de stock passé dans le constructeur est bien retourné par getType()
	 */
	@Test
	void testGetType() {
		int x = 1;
		int y = 2;
		String type = "final";
		Stock stock = new Stock(type, x, y);
		assertEquals(type, stock.getType());
	}
	
	/**
	 * On vérifie que le nombre de produits dans le stock est bien incrémenté lorsqu'on ajoute un produit
	 */
	@Test
	void testAddProduitsSize() {
		Stock stock = new Stock("type", 1, 2);
		Produit p1 = new Produit(PRODUIT1, 1);
		Produit p2 = new Produit(PRODUIT1, 1);
		Produit p3 = new Produit("produit2", 1);
		Produit p4 = new Produit("produit4", 1);
		
		assertEquals(0, stock.getProduits().size());
		
		stock.addProduit(p1);
		stock.addProduit(p2);
		stock.addProduit(p3);
		stock.addProduit(p4);
		
		assertEquals(4, stock.getProduits().size());
	}
	
	/**
	 * On vérifie que les produits ajoutés dans le stock sont bien retournés par la fonction getProduits()
	 */
	@Test
	void testAddGetProduits() {
		Stock stock = new Stock("type", 1, 2);
		Produit p1 = new Produit(PRODUIT1, 1);
		Produit p2 = new Produit(PRODUIT1, 1);
		
		stock.addProduit(p1);
		stock.addProduit(p2);
		
		assertEquals(p1, stock.getProduits().get(0));
		assertEquals(p2, stock.getProduits().get(1));	
	}
	
	/**
	 * On vérifie que les produits ajoutés dans le stock sont bien supprimés
	 */
	@Test
	void testAddRemoveProduits() {
		Stock stock = new Stock("type", 1, 2);
		Produit p1 = new Produit(PRODUIT1, 1);
		Produit p2 = new Produit(PRODUIT1, 1);
		
		assertEquals(0, stock.getProduits().size());
		
		stock.addProduit(p1);
		assertEquals(1, stock.getProduits().size());
		
		stock.addProduit(p2);
		assertEquals(2, stock.getProduits().size());
		
		assertEquals(p1, stock.getProduits().get(0));
		
		stock.removeProduit(0);
		assertEquals(1, stock.getProduits().size());
		
		assertEquals(p2, stock.getProduits().get(0));
	}
	
	
	
	
	
	
	

}
