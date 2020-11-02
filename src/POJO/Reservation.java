package POJO;

import java.io.Serializable;

public class Reservation implements Serializable {
	
	private static final long serialVersionUID = 7982945450646152881L;
	private int accompte;
	private int solde;
	private String statut;
	private int prix;
	private PlanningSalle planningSale;
	public int getAccompte() {
		return accompte;
	}
	public void setAccompte(int accompte) {
		this.accompte = accompte;
	}
	public int getSolde() {
		return solde;
	}
	public void setSolde(int solde) {
		this.solde = solde;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public PlanningSalle getPlanningSale() {
		return planningSale;
	}
	public void setPlanningSale(PlanningSalle planningSale) {
		this.planningSale = planningSale;
	}
	public Reservation(int accompte, int solde, String statut, int prix, PlanningSalle planningSale) {
		this.accompte = accompte;
		this.solde = solde;
		this.statut = statut;
		this.prix = prix;
		this.planningSale = planningSale;
	}
	
}
