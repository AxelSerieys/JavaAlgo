package test;

import org.junit.jupiter.api.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

import model.Gamme;
import model.Operation;

class GammeTest {
	
	private Logger logger = Logger.getLogger("logger");

	/**
	 * Test de la classe Gamme
	 */
	@Test
	void test() {
		Gamme gamme1 = new Gamme("GammeProduit");
		Operation ope1 = new Operation(45,"Découpage");
		Operation ope2 = new Operation(5,"Nettoyage");
		Operation ope3 = new Operation(15,"Pliage");
		
		gamme1.ajoutPhase(ope1);
		gamme1.ajoutPhase(ope3);
		
		for (int i= 0; i < gamme1.getListeGamme().size(); i++) {
			logger.log(Level.INFO, "{0} ", gamme1.getListeGamme().get(i).getTempsRealisation());
			logger.log(Level.INFO, "{0} ", gamme1.getListeGamme().get(i).getType());
		}
		logger.log(Level.INFO, "-------------------------");
		
		gamme1.ajoutEntrePhase(2, ope2);
		
		for (int i= 0; i < gamme1.getListeGamme().size(); i++) {
			logger.log(Level.INFO, "{0} ", gamme1.getListeGamme().get(i).getTempsRealisation());
			logger.log(Level.INFO, "{0} ", gamme1.getListeGamme().get(i).getType());
		}	
		logger.log(Level.INFO, "-------------------------");
		
		gamme1.supprPhase(ope3);
		
		for (int i= 0; i < gamme1.getListeGamme().size(); i++) {
			logger.log(Level.INFO, "{0} ", gamme1.getListeGamme().get(i).getTempsRealisation()+ " ");
			logger.log(Level.INFO, "{0} ", gamme1.getListeGamme().get(i).getType());
		}
	}

}
