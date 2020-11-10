package POJO;

import java.io.Serializable;
import java.sql.Date;

public class Representation implements Serializable {
	
	private static final long serialVersionUID = -2923681938515090757L;
	private Date date;
	private Spectacle spectacle;
	private Date heureDebut;
	private Date heureFin;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Spectacle getSpectacle() {
		return spectacle;
	}
	public void setSpectacle(Spectacle spectacle) {
		this.spectacle = spectacle;
	}
	public Date getHeureDebut() {
		return heureDebut;
	}
	public void setHeureDebut(Date heureDebut) {
		this.heureDebut = heureDebut;
	}
	public Date getHeureFin() {
		return heureFin;
	}
	public void setHeureFin(Date heureFin) {
		this.heureFin = heureFin;
	}
	public Representation(Date date, Spectacle spectacle, Date heureDebut, Date heureFin) {
		this.date = date;
		this.spectacle = spectacle;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
	}
}
