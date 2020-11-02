package POJO;

import java.io.Serializable;
import java.util.*;

public class PlanningSalle implements Serializable{
	
	private static final long serialVersionUID = -5229572187353194846L;
	private Date dateDebutReservation;
	private Date dateFinReservation;
	private List<Spectacle> spectacle;
	public Date getDateDebutReservation() {
		return dateDebutReservation;
	}
	public void setDateDebutReservation(Date dateDebutReservation) {
		this.dateDebutReservation = dateDebutReservation;
	}
	public Date getDateFinReservation() {
		return dateFinReservation;
	}
	public void setDateFinReservation(Date dateFinReservation) {
		this.dateFinReservation = dateFinReservation;
	}
	public List<Spectacle> getSpectacle() {
		return spectacle;
	}
	public void setSpectacle(List<Spectacle> spectacle) {
		this.spectacle = spectacle;
	}
	public PlanningSalle(Date dateDebutReservation, Date dateFinReservation, List<Spectacle> spectacle) {
		this.dateDebutReservation = dateDebutReservation;
		this.dateFinReservation = dateFinReservation;
		this.spectacle = spectacle;
	}
	
	
}
