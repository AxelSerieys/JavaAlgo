package Test;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import Model.Operation;

class OperationTest {

	
	/**
	 * Test creation operation
	 */
	@Ignore
	void test() {
		Operation ope1 = new Operation(45,"D�coupage");
		System.out.println(ope1.getTempsRealisation() + " "+ ope1.getType());
		System.out.println("==================");
	}
	
	/**
	 * Test ajout operation et son affichage 
	 */
	@Ignore
	void test1() {
		Operation ope1 = new Operation(45,"D�coupage");
		Operation ope2 = new Operation(5,"Nettoyage");
		Operation.ajoutOperation(ope1);
		Operation.ajoutOperation(ope2);

		for (int i= 0; i < Operation.listeOperation.size(); i++) {
			System.out.print(Operation.listeOperation.get(i).getTempsRealisation()+ " ");
			System.out.println(Operation.listeOperation.get(i).getType());
		}
		System.out.println("==================");
	}
	
	/**
	 * Test ajout operation et son affichage 
	 */
	@Test
	void test2() {
		Operation ope1 = new Operation(45,"D�coupage");
		Operation ope2 = new Operation(5,"Nettoyage");
		Operation ope3 = new Operation(15,"Pliage");
		Operation.ajoutOperation(ope1);
		Operation.ajoutOperation(ope2);
		Operation.ajoutOperation(ope3);

		for (int i= 0; i < Operation.listeOperation.size(); i++) {
			System.out.print(Operation.listeOperation.get(i).getTempsRealisation()+ " ");
			System.out.println(Operation.listeOperation.get(i).getType());
		}
		Operation.supprOperation(ope2);
		
		for (int i= 0; i < Operation.listeOperation.size(); i++) {
			System.out.print(Operation.listeOperation.get(i).getTempsRealisation()+ " ");
			System.out.println(Operation.listeOperation.get(i).getType());
		}
		System.out.println("==================");
	}

}
