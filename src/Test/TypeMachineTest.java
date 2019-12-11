package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Model.TypeMachines;

class TypeMachineTest {

	@Test
	void testTypeMachine() {
		String type = "type";
		TypeMachines t = new TypeMachines(type);
		
		assertEquals(type, t.getType());
	}

}
