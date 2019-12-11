package test;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import model.Operation;

class OperationTest {

	private Logger logger = Logger.getLogger("logger");
	private static final String SEPARATOR = "==================";
	private static final String DECOUPAGE = "Découpage";
	
	/**
	 * Test creation operation
	 */
	@Ignore
	void test() {
		Operation ope1 = new Operation(45, DECOUPAGE);
		logger.log(Level.INFO, "{0} {1}", new Object[] {ope1.getTempsRealisation(), ope1.getType()});
		logger.log(Level.INFO, SEPARATOR);
	}
	
	/**
	 * Test ajout operation et son affichage 
	 */
	@Ignore
	void test1() {
		Operation ope1 = new Operation(45, DECOUPAGE);
		Operation ope2 = new Operation(5,"Nettoyage");
		Operation.ajoutOperation(ope1);
		Operation.ajoutOperation(ope2);

		for (int i= 0; i < Operation.getListOperation().size(); i++) {
			logger.log(Level.INFO, "{}", Operation.getListOperation().get(i).getTempsRealisation());
			logger.log(Level.INFO, "{}", Operation.getListOperation().get(i).getType());
		}
		logger.log(Level.INFO, SEPARATOR);
	}
	
	/**
	 * Test ajout operation et son affichage 
	 */
	@Test
	void test2() {
		Operation ope1 = new Operation(45, DECOUPAGE);
		Operation ope2 = new Operation(5,"Nettoyage");
		Operation ope3 = new Operation(15,"Pliage");
		Operation.ajoutOperation(ope1);
		Operation.ajoutOperation(ope2);
		Operation.ajoutOperation(ope3);

		for (int i= 0; i < Operation.getListOperation().size(); i++) {
			logger.log(Level.INFO, "{}", Operation.getListOperation().get(i).getTempsRealisation()+ " ");
			logger.log(Level.INFO, "{}", Operation.getListOperation().get(i).getType());
		}
		Operation.supprOperation(ope2);
		
		for (int i= 0; i < Operation.getListOperation().size(); i++) {
			logger.log(Level.INFO, "{}", Operation.getListOperation().get(i).getTempsRealisation()+ " ");
			logger.log(Level.INFO, "{}", Operation.getListOperation().get(i).getType());
		}
		logger.log(Level.INFO, SEPARATOR);
	}

}
