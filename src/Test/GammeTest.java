package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Model.Gamme;
import Model.Operation;

class GammeTest {

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
		
		for (int i= 0; i < Gamme.listeGamme.size(); i++) {
			System.out.print(Gamme.listeGamme.get(i).getTempsRealisation()+ " ");
			System.out.println(Gamme.listeGamme.get(i).getType());
		}
		System.out.println("-------------------------");
		
		gamme1.ajoutEntrePhase(2, ope2);
		
		for (int i= 0; i < Gamme.listeGamme.size(); i++) {
			System.out.print(Gamme.listeGamme.get(i).getTempsRealisation()+ " ");
			System.out.println(Gamme.listeGamme.get(i).getType());
		}	
		System.out.println("-------------------------");
		
		gamme1.supprPhase(ope3);
		
		for (int i= 0; i < Gamme.listeGamme.size(); i++) {
			System.out.print(Gamme.listeGamme.get(i).getTempsRealisation()+ " ");
			System.out.println(Gamme.listeGamme.get(i).getType());
		}
	}

}
