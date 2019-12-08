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
	//Enum�ration des types?
	private TypeMachine type;
	
	/**
	 * Cr�e un �lot
	 * @param type : le type de machines composant l'�lot
	 * @param x : position en x de l'�lot
	 * @param y : position en y de l'�lot
	 */
	public Ilot(TypeMachine type, int x, int y) {
		super(x,y);
		this.type=type;
	}
	
	/**
	 * Ajoute une machine � l'�lot
	 * @param machine : machine � ajouter � l'�lot
	 */
	public void AjoutMachine(Machine machine) {
		if(machine.getType()==this.type) {
			this.nbMachines++;
		} else {
			System.out.println("Type de la machine different de celui acc�pt� par l'�lot");
		}
	}
	
	/**
	 * Renvoie le type des machines composant l'�lot
	 * @return type de machine
	 */
	public TypeMachine getType() {
		return type;
	}
}
