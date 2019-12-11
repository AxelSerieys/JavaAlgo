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
	 * Test de la méthode phaseSuivante() de Stock
	 */
	@Test
	void testPhaseSuivante() {
		int phase=25;
		Produit p = new Produit("88", phase);
		p.phaseSuivante();
		
		assertEquals(phase+1, p.getNumeroPhase());
	}
	
	@Test
	void testEstFini() {
		Produit p = new Produit("A", 0);
		assertFalse(p.estFini());
		
		p.fin();
		assertTrue(p.estFini());
	}

}
