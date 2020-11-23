package POJO;

import java.io.Serializable;

import DAO.AbstractDAOFactory;
import DAO.DAO;

public class Place implements Serializable{
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Place> placeDAO = adf.getPlaceDAO();
	private static final long serialVersionUID = -7931337322241713429L;
	private int numPlace;
	private double prix;
	private Representation representation;
	public int getNumPlace() {
		return numPlace;
	}
	public void setNumPlace(int numPlace) {
		this.numPlace = numPlace;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public Representation getRepresentation() {
		return representation;
	}
	public void setRepresentation(Representation representation) {
		this.representation = representation;
	}
	public Place(int numPlace, double prix, Representation representation) {
		this.numPlace = numPlace;
		this.prix = prix;
		this.representation = representation;
	}
	public void calculerPrix(double prix,int nombre)
	{
		this.prix+=prix*nombre;
	}
	public boolean ajouterPlace()
	{
		placeDAO.create(this);
		return true;
	}
	
}
