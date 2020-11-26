package POJO;

import java.io.Serializable;

import DAO.AbstractDAOFactory;
import DAO.ArtisteDAO;
import DAO.DAO;

public class Artiste extends Personne implements Serializable{
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Artiste> artisteDAO = adf.getArtisteDAO();
	private static final long serialVersionUID = -2092818064731977166L;
	
	public Artiste(int id, String nom, String prenom, String adresse) {
		super(id, nom, prenom, adresse);
	}
	public Artiste(String nom, String prenom, String adresse) {
		super(nom, prenom, adresse);
	}
	public String toString() {
		return Nom + " " + Prenom + " " + Id;
	}
	public Artiste(String nom, String prenom, String adresse, String email, String password) {
		super(nom, prenom, adresse, email, password);
		// TODO Auto-generated constructor stub
	}
	public Artiste(String nom, String prenom, String adresse, String email, String password, int id) {
		super(nom, prenom, adresse, email, password, id);
		// TODO Auto-generated constructor stub
	}
	public Artiste find()
	{
		return ((ArtisteDAO)artisteDAO).find(this.getEmail());
	}
	public boolean creer()
	{
		artisteDAO.create(this);
		return true;
	}
}
