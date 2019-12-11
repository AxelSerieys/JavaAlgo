package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Model.Convoyeur;
import Model.Produit;

class ConvoyeurTest {

	/**
	 * On teste la m�thode getCapacit� apr�s la cr�ation d'un convoyeur
	 */
	@Test
	void testGetCapacite() {
		int capacite=32;
		Convoyeur c = new Convoyeur(1, 2, capacite, 1);
		
		assertEquals(capacite, c.getCapacite());
	}
	
	/**
	 * On teste la m�thode getVitesse apr�s la cr�ation d'un convoyeur
	 */
	@Test
	void testGetVitesse() {
		int vitesse = 3;
		Convoyeur c = new Convoyeur(1, 1, 32, vitesse);
		
		assertEquals(vitesse, c.getVitesseDeplacement());
	}
	
	/**
	 * On teste la mise � jour du produit stock� dans un convoyeur
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
	 * On teste la m�thode setVitesseDeplacement qui met � jour la vitesse de d�placement d'un convoyeur
	 */
	@Test
	void testSetVitesseDeplacement() {
		int vitesse=32;
		Convoyeur c = new Convoyeur(1, 2, 3, 4);
		c.setVitesseDeplacement(vitesse);
		
		assertEquals(vitesse, c.getVitesseDeplacement());
	}
	
	/**
	 * On teste la m�thode setCapacite qui met � jour la capacit� maximale d'un convoyeur
	 */
	@Test
	void testSetCapacite() {
		int capacite=12;
		Convoyeur c = new Convoyeur(1, 2, 3, 4);
		c.setCapacite(capacite);
		
		assertEquals(capacite, c.getCapacite());
	}

}
