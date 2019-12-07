package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Model.Operation;

class OperationTest {

	
	/**
	 * Test creation operation
	 */
	@Test
	void test() {
		Operation ope1 = new Operation(45,"Découpage");
		System.out.println(ope1.getTempsRealisation() + " "+ ope1.getType());
		System.out.println("==================");
	}
	
	/**
	 * Test ajout operation et son affichage 
	 */
	@Test
	void test1() {
		Operation ope1 = new Operation(45,"Découpage");
		Operation ope2 = new Operation(5,"Nettoyage");
		Operation.ajoutOperation(ope1);
		Operation.ajoutOperation(ope2);

		for (int i= 0; i < Operation.listeOperation.size(); i++) {
			System.out.print(Operation.listeOperation.get(i).getTempsRealisation()+ " ");
			System.out.println(Operation.listeOperation.get(i).getType());
		}
		System.out.println("==================");
	}

}
