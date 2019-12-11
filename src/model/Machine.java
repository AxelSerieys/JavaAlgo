package model;

/**
 * Machine modifiant des pièces
 * @author Victor
 * Créé le: 06/12/2019
 */

public class Machine {
	private TypeMachines type;
	private boolean utilise;
	
	/**
	 * Crée une machine
	 * @param type : le type de la machine
	 */
	public Machine(TypeMachines type) {
		this.type=type;
		this.utilise=false;
	}
	
	/**
	 * Change l'état de la machine à "utilisé"
	 */
	public void estUtil() {
		this.utilise=true;
	}
	
	/**
	 * Change l'état de la machine à "non utilisé"
	 */
	public void pasUtil() {
		this.utilise=false;
	}
	
	/**
	 * Renvoie l'état de la machine
	 * @return true si la machine est utilisée, false sinon
	 */
	public boolean getUtil() {
		return this.utilise;
	}
	/**
	 * Renvoie le type de la machine
	 * @return type de machine
	 */
	public String getType() {
		return type.getType();
	}
}
