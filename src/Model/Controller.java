package Model;

public class Controller {
	private int tpsTotalTrait=0;
	
	public double calculDistance(ElementEspace a, ElementEspace b) {
		return Math.sqrt(Math.pow(b.getPositionY()-a.getPositionY(),2)+Math.pow(b.getPositionX()-a.getPositionX(),2));
	}
	
	public void lancerSimulation() {
		
	}
	
	public double calculTpsDeplacement(double distance, int vitesse) {
		return (distance/vitesse);
	}
}
