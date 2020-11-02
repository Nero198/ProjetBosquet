package POJO;

import java.io.Serializable;

public class Categorie implements Serializable {
	
	private static final long serialVersionUID = -4970894858370070953L;
	private String type;
	private String prix;
	private int nbrPlaceDispo;
	private int nbrPlaceMax;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPrix() {
		return prix;
	}
	public void setPrix(String prix) {
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
	public Categorie(String type, String prix, int nbrPlaceDispo, int nbrPlaceMax) {
		this.type = type;
		this.prix = prix;
		this.nbrPlaceDispo = nbrPlaceDispo;
		this.nbrPlaceMax = nbrPlaceMax;
	}
}
