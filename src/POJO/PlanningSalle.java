package POJO;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

import DAO.AbstractDAOFactory;
import DAO.*;

public class PlanningSalle implements Serializable{
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<PlanningSalle> planningSalleDAO = adf.getPlanningSalleDAO();
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
	public boolean verifierDisponibilite() {
		List<PlanningSalle> liste = ((PlanningSalleDAO)planningSalleDAO).find();
		boolean dispo = false;
		for(var ps : liste)
		{
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
			System.out.println(this.dateDebutReservation.compareTo(ps.dateDebutReservation));
			System.out.println(dateFormat.format(ps.dateDebutReservation));
			if((this.dateDebutReservation.compareTo(ps.dateDebutReservation)>0)&&((this.dateDebutReservation.compareTo(ps.dateFinReservation)<0)))
				return false;
			else
			{
				dispo=true;
				if((this.dateFinReservation.compareTo(ps.dateDebutReservation)>0)&&((this.dateFinReservation.compareTo(ps.dateFinReservation)<0)))
					return false;
				else
					dispo=true;
			}
		}
		return dispo;
	}
	
}
