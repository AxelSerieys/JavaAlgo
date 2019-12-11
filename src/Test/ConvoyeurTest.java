package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Model.Convoyeur;
import Model.Produit;

class ConvoyeurTest {

	/**
	 * On teste la méthode getCapacité après la création d'un convoyeur
	 */
	@Test
	void testGetCapacite() {
		int capacite=32;
		Convoyeur c = new Convoyeur(1, 2, capacite, 1);
		
		assertEquals(capacite, c.getCapacite());
	}
	
	/**
	 * On teste la méthode getVitesse après la création d'un convoyeur
	 */
	@Test
	void testGetVitesse() {
		int vitesse = 3;
		Convoyeur c = new Convoyeur(1, 1, 32, vitesse);
		
		assertEquals(vitesse, c.getVitesseDeplacement());
	}
	
	/**
	 * On teste la mise à jour du produit stocké dans un convoyeur
	 */
	@Test
	void testSetProduit() {
		Convoyeur c = new Convoyeur(1, 2, 32, 3);
		Produit p = new Produit("type", 1);
		Produit p2 = new Produit("type", 2);
		
		c.setProduit(p);
		assertEquals(p, c.getProduit());
		
		c.setProduit(p2);
		assertEquals(p2, c.getProduit());
	}
	
	/**
	 * Teste la fonction drop produit
	 */
	@Test
	void testDropProduit() {
		Produit p = new Produit("oui", 2);
		Convoyeur c = new Convoyeur(1, 2, 3, 4);
		c.setProduit(p);
		
		assertEquals(p, c.getProduit());
		c.dropProduit();
		assertNull(c.getProduit());
	}
	
	/**
	 * Teste le déplacement d'un convoyeur et les méthodes getDeplacement et setDeplacement
	 */
	@Test
	void testDeplacement() {
		Convoyeur c = new Convoyeur(1, 2, 3, 4);
		assertFalse(c.getDeplacement());
		c.setDeplacement(true);
		assertTrue(c.getDeplacement());
		c.setDeplacement(false);
		assertFalse(c.getDeplacement());
	}

}
