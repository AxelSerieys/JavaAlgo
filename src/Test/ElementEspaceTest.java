package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Model.ElementEspace;

class ElementEspaceTest {

	@Test
	void testElementEspace() {
		int posX = 1;
		int posY = 2;
		
		ElementEspace e = new ElementEspace(posX, posY);
		
		assertEquals(posX, e.getPositionX());
		assertEquals(posY, e.getPositionY());
	}

}
