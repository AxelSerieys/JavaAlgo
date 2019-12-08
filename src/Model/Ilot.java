package Model;
import java.util.*;

/**
 * Îlot composé de machines
 * @author Victor
 * Créé le: 06/12/2019
 */

public class Ilot extends ElementEspace{
	private ArrayList<String> fileAttenteEntree;
	private ArrayList<String> fileAttenteSortie;
	private int nbMachines;
	//Enumération des types?
	private TypeMachine type;
	
	/**
	 * Crée un îlot
	 * @param type : le type de machines composant l'îlot
	 * @param x : position en x de l'îlot
	 * @param y : position en y de l'îlot
	 */
	public Ilot(TypeMachine type, int x, int y) {
		super(x,y);
		this.type=type;
	}
	
	/**
	 * Ajoute une machine à l'îlot
	 * @param machine : machine à ajouter à l'îlot
	 */
	public void AjoutMachine(Machine machine) {
		if(machine.getType()==this.type) {
			this.nbMachines++;
		} else {
			System.out.println("Type de la machine different de celui accépté par l'îlot");
		}
	}
	
	/**
	 * Renvoie le type des machines composant l'îlot
	 * @return type de machine
	 */
	public TypeMachine getType() {
		return type;
	}
}
