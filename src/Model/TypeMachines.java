package Model;

/**
 * Chaque machine a un type qui d�finit ce qu'elle fait
 * @author aserieys
 * Cr�� le: 11/12/2019
 *
 */
public class TypeMachines {
	private String type; 
	
	/**
	 * Constructeur de TypeMachines
	 * @param type le nom du type
	 */
	public TypeMachines(String type) {
		this.type=type;
	}
	
	/**
	 * Renvoie le nom du type de machines
	 * @return le nom du type de machines
	 */
	public String getType() {
		return this.type;
	}

}
