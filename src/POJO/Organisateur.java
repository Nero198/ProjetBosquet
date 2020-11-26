package POJO;

import java.io.Serializable;
import java.util.*;

import DAO.AbstractDAOFactory;
import DAO.DAO;
import DAO.OrganisateurDAO;

public class Organisateur extends Personne implements Serializable{
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Organisateur> organisateurDAO = adf.getOrganisateurDAO();

	private List<Reservation> reservations;
	public Organisateur(String nom, String prenom, String adresse, String email, String password) {
		super(nom, prenom, adresse, email, password);
		// TODO Auto-generated constructor stub
	}
	public Organisateur(String nom, String prenom, String adresse, String email, String password, List<Reservation> reservations) {
		super(nom, prenom, adresse, email, password);
		// TODO Auto-generated constructor stub
		this.reservations=reservations;
	}
	public Organisateur(String nom, String prenom, String adresse, String email, String password, int id) {
		super(nom, prenom, adresse, email, password, id);
		// TODO Auto-generated constructor stub
	}
	public Organisateur(String nom, String prenom, String adresse, List<Reservation> reservations) {
		super(nom, prenom, adresse);
		// TODO Auto-generated constructor stub
		this.reservations=reservations;
	}
	private static final long serialVersionUID = 6277529504871654921L;
	public List<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	public Organisateur(int id, String nom, String prenom, String adresse, List<Reservation> reservations) {
		super(id,nom, prenom, adresse);
		this.reservations=reservations;
	}
	public Organisateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public boolean ajouterRepresentation(Representation r)
	{
		r.ajouterRepresentation();
		return true;
	}
	public void reserverSalle(Reservation r)
	{
		System.out.print("Dans Orga");
		Organisateur o = ((OrganisateurDAO)organisateurDAO).find(this.getEmail());
		r.creerReservation(o);
	}
	public boolean ajouterSpectacle(Spectacle s,PlanningSalle ps)
	{
		s.ajouterSpectacle(ps);
		return true;
	}
	public boolean creer()
	{
		organisateurDAO.create(this);
		return true;
	}
	public void getReservation()
	{
		List<Reservation> res = ((OrganisateurDAO)organisateurDAO).findAll(this.getId());
		this.setReservations(res);
	}
}
