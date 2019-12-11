package model;

/**
 * Machine modifiant des pi�ces
 * @author Victor
 * Cr�� le: 06/12/2019
 */

public class Machine {
	private TypeMachines type;
	private boolean utilise;
	
	/**
	 * Cr�e une machine
	 * @param type : le type de la machine
	 */
	public Machine(TypeMachines type) {
		this.type=type;
		this.utilise=false;
	}
	
	/**
	 * Change l'�tat de la machine � "utilis�"
	 */
	public void estUtil() {
		this.utilise=true;
	}
	
	/**
	 * Change l'�tat de la machine � "non utilis�"
	 */
	public void pasUtil() {
		this.utilise=false;
	}
	
	/**
	 * Renvoie l'�tat de la machine
	 * @return true si la machine est utilis�e, false sinon
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
