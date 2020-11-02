package POJO;

import java.io.Serializable;
import java.util.*;

public class Client extends Personne implements Serializable{
	
	private static final long serialVersionUID = -369474509108260321L;
	private List<Commande> commandes;
	public List<Commande> getCommandes() {
		return commandes;
	}
	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}
	public Client(int id,String nom, String prenom, String adresse,List<Commande> commandes) {
		super(id,nom,prenom,adresse);
		this.commandes=commandes;
	}
	
	public Client(String nom, String prenom, String adresse, String email, String password,List<Commande> commandes) {
		super(nom, prenom, adresse, email, password);
		// TODO Auto-generated constructor stub
		this.commandes=commandes;
	}
	public Client(String nom, String prenom, String adresse,List<Commande> commandes) {
		super(nom, prenom, adresse);
		// TODO Auto-generated constructor stub
		this.commandes=commandes;
	}
	public Client(String nom, String prenom, String adresse, String email, String password, int id,List<Commande> commandes) {
		super(nom, prenom, adresse, email, password, id);
		// TODO Auto-generated constructor stub
		this.commandes=commandes;
	}
	
}
