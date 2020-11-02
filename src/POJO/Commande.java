package POJO;

import java.io.Serializable;
import java.util.*;

public class Commande implements Serializable{
	
	private static final long serialVersionUID = 225750152650069228L;
	private String modePayement;
	private String modeLivraison;
	private int cout;
	private List<Place> places;
	public String getModePayement() {
		return modePayement;
	}
	public void setModePayement(String modePayement) {
		this.modePayement = modePayement;
	}
	public String getModeLivraison() {
		return modeLivraison;
	}
	public void setModeLivraison(String modeLivraison) {
		this.modeLivraison = modeLivraison;
	}
	public int getCout() {
		return cout;
	}
	public void setCout(int cout) {
		this.cout = cout;
	}
	public List<Place> getPlaces() {
		return places;
	}
	public void setPlaces(List<Place> places) {
		this.places = places;
	}
	public Commande(String modePayement, String modeLivraison, int cout, List<Place> places) {
		this.modePayement = modePayement;
		this.modeLivraison = modeLivraison;
		this.cout = cout;
		this.places = places;
	}
}
