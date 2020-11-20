package POJO;

import java.io.Serializable;

import DAO.AbstractDAOFactory;
import DAO.CategorieDAO;
import DAO.DAO;

public class Categorie implements Serializable {
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Categorie> categorieDAO = adf.getCatetogieDAO();
	private static final long serialVersionUID = -4970894858370070953L;
	private String type;
	private double prix;
	private int nbrPlaceDispo;
	private int nbrPlaceMax;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getNbrPlaceDispo() {
		return nbrPlaceDispo;
	}
	public void setNbrPlaceDispo(int nbrPlaceDispo) {
		this.nbrPlaceDispo = nbrPlaceDispo;
	}
	public int getNbrPlaceMax() {
		return nbrPlaceMax;
	}
	public void setNbrPlaceMax(int nbrPlaceMax) {
		this.nbrPlaceMax = nbrPlaceMax;
	}
	public Categorie(String type, double prix, int nbrPlaceDispo, int nbrPlaceMax) {
		this.type = type;
		this.prix = prix;
		this.nbrPlaceDispo = nbrPlaceDispo;
		this.nbrPlaceMax = nbrPlaceMax;
	}
	public Categorie() {
	}
	@Override
	public String toString() {
		return "Categorie [type=" + type + ", prix=" + prix + ", nbrPlaceDispo=" + nbrPlaceDispo + ", nbrPlaceMax="
				+ nbrPlaceMax + "]";
	}
	public void ajouterCategorie(Configuration configuration)
	{
		categorieDAO.create(this);
		((CategorieDAO)categorieDAO).ajouterConfiguration(configuration.getId());
	}
}
