package Model;

/**
 * Machine modifiant des pi�ces
 * @author Victor
 * Cr�� le: 06/12/2019
 */

public class Machine {
	private TypeMachines type;
	
	/**
	 * Cr�e une machine
	 * @param type : le type de la machine
	 */
	public Machine(TypeMachines type) {
		this.type=type;
	}
	
	/**
	 * Renvoie le type de la machine
	 * @return type de machine
	 */
	public String getType() {
		return type.getType();
	}
}
