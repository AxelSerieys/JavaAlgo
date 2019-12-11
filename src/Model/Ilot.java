package Model;
import java.util.*;

/**
 * �lot compos� de machines
 * @author Victor
 * Cr�� le: 06/12/2019
 */

public class Ilot extends ElementEspace{
	private ArrayList<String> fileAttenteEntree;
	private ArrayList<String> fileAttenteSortie;
	private int nbMachines;
	private TypeMachines type;
	private Operation operation;
	
	/**
	 * Cr�e un �lot
	 * @param type : le type de machines composant l'�lot
	 * @param x : position en x de l'�lot
	 * @param y : position en y de l'�lot
	 * @param taille : taille des files d'attentes de l'�lot
	 */
	public Ilot(TypeMachines type, int x, int y, int taille, Operation op) {
		super(x,y);
		fileAttenteEntree=new ArrayList<String>(taille);
		fileAttenteSortie=new ArrayList<String>(taille);
		this.type=type;
		this.operation=op;
	}
	
	/**
	 * Ajoute une machine � l'�lot
	 * @param machine : machine � ajouter � l'�lot
	 */
	public void AjoutMachine(Machine machine) {
		if(machine.getType()==this.type.getType()) {
			this.nbMachines++;
		} else {
			System.out.println("Type de la machine different de celui acc�pt� par l'�lot");
		}
	}
	
	/**
	 * Renvoie le type des machines composant l'�lot
	 * @return type de machine
	 */
	public String getType() {
		return type.getType();
	}
	
	public Operation getOperation() {
		return this.operation;
	}
}
