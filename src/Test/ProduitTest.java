package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Model.Produit;

class ProduitTest {
	
	
	/**
	 * Test de la m�thode getType de Stock
	 */
	@Test
	void testGetType() {
		String type="p1";
		Produit p = new Produit(type, 1);
		
		assertEquals(type, p.getType());
	}
	
	/**
	 * Test de la m�thode getNumeroPhase de Stock
	 */
	@Test
	void testGetNumeroPhase() {
		int phase = 92;
		Produit p = new Produit("", phase);
		
		assertEquals(phase, p.getNumeroPhase());
	}
	
	/**
	 * Test de la m�thode setNumeroPhase de Stock
	 */
	@Test
	void testSetNumeroPhase() {
		int phase=25;
		Produit p = new Produit("88", 9);
		p.setNumeroPhase(phase);
		
		assertEquals(phase, p.getNumeroPhase());
	}

}
