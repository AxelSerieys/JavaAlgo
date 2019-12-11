package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.TypeMachines;

class TypeMachineTest {

	/**
	 * Teste la méthode getType() après la création d'un TypeMachine
	 */
	@Test
	void testTypeMachine() {
		String type = "type";
		TypeMachines t = new TypeMachines(type);
		
		assertEquals(type, t.getType());
	}

}
