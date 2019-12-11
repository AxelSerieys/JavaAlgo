package Model;
import java.util.*;

/**
 * Îlot composé de machines
 * @author Victor
 * Créé le: 06/12/2019
 */

public class Ilot extends ElementEspace{
	private ArrayList<Produit> fileAttenteEntree;
	private ArrayList<Produit> fileAttenteSortie;
	private ArrayList<Machine> fileMachines;
	private TypeMachines type;
	private Operation operation;
	
	/**
	 * Crée un îlot
	 * @param type : le type de machines composant l'îlot
	 * @param x : position en x de l'îlot
	 * @param y : position en y de l'îlot
	 * @param op : Operation liée à l'îlot
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
	 * Ajoute une machine à l'îlot
	 * @param machine : machine à ajouter à l'îlot
	 */
	public void AjoutMachine(Machine machine) {
		if(machine.getType()==this.type.getType()) {
			this.fileMachines.add(machine);
		} else {
			System.out.println("Type de la machine different de celui accépté par l'îlot");
		}
	}
	
	public void ajoutPdt(Produit pdt) {
		fileAttenteEntree.add(pdt);
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
