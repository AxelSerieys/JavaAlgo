package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Model.ElementEspace;

class ElementEspaceTest {

	/**
	 * Teste la création d'un convoyeur
	 */
	@Test
	void testElementEspace() {
		int posX = 1;
		int posY = 2;
		
		ElementEspace e = new ElementEspace(posX, posY);
		
		assertEquals(posX, e.getPositionX());
		assertEquals(posY, e.getPositionY());
	}

}
