package POJO;

import java.io.Serializable;

public class Artiste extends Personne implements Serializable{
	
	private static final long serialVersionUID = -2092818064731977166L;
	
	public Artiste(int id, String nom, String prenom, String adresse) {
		super(id, nom, prenom, adresse);
	}
	public Artiste(String nom, String prenom, String adresse) {
		super(nom, prenom, adresse);
	}
	public String toString() {
		return "Artiste [Nom=" + Nom + ", Prenom=" + Prenom + ", Adresse=" + Adresse + ", Id=" + Id + "]";
	}
	public Artiste(String nom, String prenom, String adresse, String email, String password) {
		super(nom, prenom, adresse, email, password);
		// TODO Auto-generated constructor stub
	}
	public Artiste(String nom, String prenom, String adresse, String email, String password, int id) {
		super(nom, prenom, adresse, email, password, id);
		// TODO Auto-generated constructor stub
	}

}
