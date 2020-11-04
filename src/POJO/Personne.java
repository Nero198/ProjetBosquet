package POJO;

import java.io.Serializable;

public abstract class Personne implements Serializable{
	
	private static final long serialVersionUID = 39257180305531733L;
	protected String Nom;
	protected String Prenom;
	protected String Adresse;
	protected String Email;
	protected String Password;
	public Personne(String nom, String prenom, String adresse, String email, String password) {
		Nom = nom;
		Prenom = prenom;
		Adresse = adresse;
		Email = email;
		Password = password;
	}
	public Personne(String nom, String prenom, String adresse, String email, String password, int id) {
		Nom = nom;
		Prenom = prenom;
		Adresse = adresse;
		Email = email;
		Password = password;
		Id = id;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	protected int Id;
	public Personne(int id, String nom, String prenom, String adresse) {
		Nom = nom;
		Prenom = prenom;
		Adresse = adresse;
		Id = id;
	}
	public Personne(String nom, String prenom, String adresse) {
		Nom = nom;
		Prenom = prenom;
		Adresse = adresse;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public String getAdresse() {
		return Adresse;
	}
	public void setAdresse(String adresse) {
		Adresse = adresse;
	}
	public boolean verifierMotDePasse(String mdp)
	{
		return this.getPassword().equals(mdp);
	}
	
}
