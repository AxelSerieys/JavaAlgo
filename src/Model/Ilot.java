package Model;
import java.util.*;

public class Ilot extends ElementEspace{
	private ArrayList<String> fileAttenteEntree;
	private ArrayList<String> fileAttenteSortie;
	private int nbMachines;
	//Enumération des types?
	private TypeMachine type;
	
	public Ilot(TypeMachine type, int x, int y) {
		super(x,y);
		this.type=type;
	}
	
	public TypeMachine getType() {
		return type;
	}
}
