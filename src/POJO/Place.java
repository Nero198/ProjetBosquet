package POJO;

import java.io.Serializable;

public class Place implements Serializable{
	
	private static final long serialVersionUID = -7931337322241713429L;
	private int numPlace;
	private int prix;
	private Representation representation;
	public int getNumPlace() {
		return numPlace;
	}
	public void setNumPlace(int numPlace) {
		this.numPlace = numPlace;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public Representation getRepresentation() {
		return representation;
	}
	public void setRepresentation(Representation representation) {
		this.representation = representation;
	}
	public Place(int numPlace, int prix, Representation representation) {
		this.numPlace = numPlace;
		this.prix = prix;
		this.representation = representation;
	}
	
}
