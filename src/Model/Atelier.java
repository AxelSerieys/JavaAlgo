package Model;

import java.util.List;

/**
 * Atelier contenant une chaine de production
 * @author nathan
 * Créé le: 07/12/2019
 */
public class Atelier {
	
	/** Attribut Atelier: Liste element **/
	private List<ElementEspace> element;

	/** Getter d'un element **/
	public List<ElementEspace> getElement() {
		return element;
	}

	/** Setter d'un element **/
	public void setElement(List<ElementEspace> element) {
		this.element = element;
	}
	
	
}
