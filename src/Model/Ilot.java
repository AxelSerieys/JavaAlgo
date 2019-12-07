package Model;
import java.util.*;

public class Ilot {
	private ArrayList<String> fileAttenteEntree;
	private ArrayList<String> fileAttenteSortie;
	private int nbMachines;
	//Enumération des types?
	private String type;
	
	public void setType(String type) {
		this.type=type;
	}
	
	public String getType() {
		return type;
	}
}
