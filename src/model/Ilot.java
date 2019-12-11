package model;
import java.util.*;
import java.util.logging.*;

/**
 * �lot compos� de machines
 * @author Victor
 * Cr�� le: 06/12/2019
 */

public class Ilot extends ElementEspace{
	private ArrayList<Produit> fileAttenteEntree;
	//fileAttenteSortie n'est pas utilis�e dans cette version
	private ArrayList<Machine> fileMachines;
	private TypeMachines type;
	private Operation operation;
	private Logger logger = Logger.getLogger("logger");
	
	/**
	 * Cr�e un �lot
	 * @param type : le type de machines composant l'�lot
	 * @param x : position en x de l'�lot
	 * @param y : position en y de l'�lot
	 * @param op : Operation li�e � l'�lot
	 */
	public Ilot(TypeMachines type, int x, int y, Operation op) {
		super(x,y);
		fileAttenteEntree = new ArrayList<>();
		this.type = type;
		this.operation = op;
		this.fileMachines = new ArrayList<>();
	}
	
	/**
	 * Ajoute une machine � l'�lot
	 * @param machine : machine � ajouter � l'�lot
	 */
	public void ajoutMachine(Machine machine) {
		if(machine.getType().equals(this.type.getType())) {
			this.fileMachines.add(machine);
		} else {
			logger.log(Level.INFO, "Type de la machine different de celui acc�pt� par l'�lot");
		}
	}
	
	/**
	 * Ajoute un produit dans la file en entr�e
	 * @param pdt : le produit � ajouter
	 */
	public void ajoutPdt(Produit pdt) {
		fileAttenteEntree.add(pdt);
	}
	
	/**
	 * Retourne la liste des machines de l'�lot
	 * @return List<Machine>
	 */
	public List<Machine> getListeMachines() {
		return this.fileMachines;
	}
	
	/**
	 * Retourne la file d'attente des produits en entr�e de l'�lot
	 * @return List<Produit> La file d'attente des produits en entr�e
	 */
	public List<Produit> getFileAttenteEntree() {
		return this.fileAttenteEntree;
	}
	
	/**
	 * Renvoie le type des machines composant l'�lot
	 * @return type de machine
	 */
	public String getType() {
		return type.getType();
	}
	
	/**
	 * Retourne l'op�ration r�alis�e sur l'�lot
	 * @return Operation l'op�ration r�alis�e par l'�lot
	 */
	public Operation getOperation() {
		return this.operation;
	}
}
