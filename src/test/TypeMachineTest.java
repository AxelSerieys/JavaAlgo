package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.TypeMachines;

class TypeMachineTest {

	/**
	 * Teste la m�thode getType() apr�s la cr�ation d'un TypeMachine
	 */
	@Test
	void testTypeMachine() {
		String type = "type";
		TypeMachines t = new TypeMachines(type);
		
		assertEquals(type, t.getType());
	}

}
