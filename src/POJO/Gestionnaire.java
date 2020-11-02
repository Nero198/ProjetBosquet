package POJO;

import java.io.Serializable;

public class Gestionnaire extends Personne implements Serializable{
	
	private static final long serialVersionUID = -4561257021111929741L;
	private PlanningSalle planningSalle;
	public PlanningSalle getPlanningSalle() {
		return planningSalle;
	}
	public void setPlanningSalle(PlanningSalle planningSalle) {
		this.planningSalle = planningSalle;
	}
	
	public Gestionnaire(int id, String nom, String prenom, String adresse,PlanningSalle planningSalle) {
		super(id, nom, prenom, adresse);
		// TODO Auto-generated constructor stub
		this.planningSalle=planningSalle;
	}
	public Gestionnaire(String nom, String prenom, String adresse, String email, String password) {
		super(nom, prenom, adresse, email, password);
		// TODO Auto-generated constructor stub
	}
	public Gestionnaire(String nom, String prenom, String adresse,PlanningSalle planningSalle) {
		super(nom, prenom, adresse);
		// TODO Auto-generated constructor stub
		this.planningSalle=planningSalle;
	}
	public Gestionnaire(String nom, String prenom, String adresse, String email, String password, int id) {
		super(nom, prenom, adresse, email, password, id);
		// TODO Auto-generated constructor stub
	}

}
