package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Model.Ilot;
import Model.Machine;
import Model.Operation;
import Model.Produit;
import Model.TypeMachines;

class IlotTest {

	@Test
	void testTypeIlot() {
		String type = "type";
		Ilot i = new Ilot(new TypeMachines(type), 1, 2, new Operation(1, "type"));
		
		assertEquals(type, i.getType());
	}
	
	@Test
	void testGestionMachine() {
		String type="type";
		String type2="type2";
		Ilot i = new Ilot(new TypeMachines(type), 1, 2, new Operation(1, "type"));
		Machine m = new Machine(new TypeMachines(type));
		Machine m2 = new Machine(new TypeMachines(type2));
		
		assertEquals(0, i.getListeMachines().size());		
		i.AjoutMachine(m);
		
		assertEquals(m, i.getListeMachines().get(0));
		assertEquals(1, i.getListeMachines().size());
		
		i.AjoutMachine(m2);
		assertEquals(1, i.getListeMachines().size());
	}
	
	@Test
	void testGestionProduit() {
		Produit p = new Produit("type", 1);
		Ilot i = new Ilot(new TypeMachines("type"), 1, 2, new Operation(1, "type"));
		
		assertEquals(0, i.getFileAttenteEntree().size());
		i.ajoutPdt(p);
		assertEquals(1, i.getFileAttenteEntree().size());		
	}
	
	@Test
	void testOperation() {
		Operation o = new Operation(1, "type");
		Ilot i = new Ilot(new TypeMachines("type"), 1, 2, o);
		
		assertEquals(o, i.getOperation());
	}

}
