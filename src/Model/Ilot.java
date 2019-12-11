package Model;
import java.util.*;

/**
 * �lot compos� de machines
 * @author Victor
 * Cr�� le: 06/12/2019
 */

public class Ilot extends ElementEspace{
	private ArrayList<Produit> fileAttenteEntree;
	private ArrayList<Produit> fileAttenteSortie;
	private ArrayList<Machine> fileMachines;
	private TypeMachines type;
	private Operation operation;
	
	/**
	 * Cr�e un �lot
	 * @param type : le type de machines composant l'�lot
	 * @param x : position en x de l'�lot
	 * @param y : position en y de l'�lot
	 * @param op : Operation li�e � l'�lot
	 */
	public Ilot(TypeMachines type, int x, int y, Operation op) {
		super(x,y);
		fileAttenteEntree=new ArrayList<Produit>();
		fileAttenteSortie=new ArrayList<Produit>();
		this.type=type;
		this.operation=op;
		this.fileMachines = new ArrayList<Machine>();
	}
	
	/**
	 * Ajoute une machine � l'�lot
	 * @param machine : machine � ajouter � l'�lot
	 */
	public void AjoutMachine(Machine machine) {
		if(machine.getType()==this.type.getType()) {
			this.fileMachines.add(machine);
		} else {
			System.out.println("Type de la machine different de celui acc�pt� par l'�lot");
		}
	}
	
	public void ajoutPdt(Produit pdt) {
		fileAttenteEntree.add(pdt);
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
