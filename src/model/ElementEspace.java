package model;

/**
 * Element de l'espace, permet le calcul des distances
 * @author Victor
 * Cr�� le: 06/12/2019
 */

public class ElementEspace {
	private int posX;
	private int posY;
	
	/**
	 * Cr�e un element avec une position
	 * @param x : position en x de l'�lot
	 * @param y : position en y de l'�lot
	 */
	public ElementEspace(int x, int y) {
		this.posX=x;
		this.posY=y;
	}
	
	/**
	 * Renvoie la position en X de l'element
	 * @return position en X
	 */
	public int getPositionX() {
		return posX;
	}

	/**
	 * Renvoie la position en Y de l'element
	 * @return position en Y
	 */
	public int getPositionY() {
		return posY;
	}
}
