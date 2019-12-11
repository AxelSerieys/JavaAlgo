package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Model.Produit;

class ProduitTest {
	
	
	/**
	 * Test de la méthode getType de Stock
	 */
	@Test
	void testGetType() {
		String type="p1";
		Produit p = new Produit(type, 1);
		
		assertEquals(type, p.getType());
	}
	
	/**
	 * Test de la méthode getNumeroPhase de Stock
	 */
	@Test
	void testGetNumeroPhase() {
		int phase = 92;
		Produit p = new Produit("", phase);
		
		assertEquals(phase, p.getNumeroPhase());
	}
	
	/**
	 * Test de la méthode setNumeroPhase de Stock
	 */
	@Test
	void testSetNumeroPhase() {
		int phase=25;
		Produit p = new Produit("88", 9);
		p.setNumeroPhase(phase);
		
		assertEquals(phase, p.getNumeroPhase());
	}

}
