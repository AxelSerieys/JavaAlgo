package Model;

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
	
	public void estUtil() {
		this.utilise=true;
	}
	
	public void pasUtil() {
		this.utilise=false;
	}
	
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
