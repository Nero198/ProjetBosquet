package POJO;

import java.io.Serializable;
import java.util.*;

public class Organisateur extends Personne implements Serializable{
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
	private List<Reservation> reservations;
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

}
