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
	public void ajoutMachine(Machine machine) {
		if(machine.getType()==this.type.getType()) {
			this.fileMachines.add(machine);
		} else {
			System.out.println("Type de la machine different de celui accépté par l'îlot");
		}
	}
	
	/**
	 * Ajoute un produit dans la file en entrée
	 * @param pdt : le produit à ajouter
	 */
	public void ajoutPdt(Produit pdt) {
		fileAttenteEntree.add(pdt);
	}
	
	/**
	 * Retourne la liste des machines de l'Îlot
	 * @return List<Machine>
	 */
	public List<Machine> getListeMachines() {
		return this.fileMachines;
	}
	
	/**
	 * Retourne la file d'attente des produits en entrée de l'Îlot
	 * @return List<Produit> La file d'attente des produits en entrée
	 */
	public List<Produit> getFileAttenteEntree() {
		return this.fileAttenteEntree;
	}
	
	/**
	 * Renvoie le type des machines composant l'îlot
	 * @return type de machine
	 */
	public String getType() {
		return type.getType();
	}
	
	/**
	 * Retourne l'opération réalisée sur l'Îlot
	 * @return Operation l'opération réalisée par l'îlot
	 */
	public Operation getOperation() {
		return this.operation;
	}
}
