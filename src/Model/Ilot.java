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
	private TypeMachines type;
	private Operation operation;
	
	/**
	 * Crée un îlot
	 * @param type : le type de machines composant l'îlot
	 * @param x : position en x de l'îlot
	 * @param y : position en y de l'îlot
	 * @param taille : taille des files d'attentes de l'îlot
	 */
	public Ilot(TypeMachines type, int x, int y, int taille, Operation op) {
		super(x,y);
		fileAttenteEntree=new ArrayList<String>(taille);
		fileAttenteSortie=new ArrayList<String>(taille);
		this.type=type;
		this.operation=op;
	}
	
	/**
	 * Ajoute une machine à l'îlot
	 * @param machine : machine à ajouter à l'îlot
	 */
	public void AjoutMachine(Machine machine) {
		if(machine.getType()==this.type.getType()) {
			this.nbMachines++;
		} else {
			System.out.println("Type de la machine different de celui accépté par l'îlot");
		}
	}
	
	/**
	 * Renvoie le type des machines composant l'îlot
	 * @return type de machine
	 */
	public String getType() {
		return type.getType();
	}
	
	public Operation getOperation() {
		return this.operation;
	}
}
