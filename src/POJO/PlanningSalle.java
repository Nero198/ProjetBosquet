package POJO;

import java.io.Serializable;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

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
	@SuppressWarnings("deprecation")
	public boolean verifierDisponibilite() {
		List<PlanningSalle> liste = ((PlanningSalleDAO)planningSalleDAO).find();
		boolean verif = false;
		if(liste.size()==0)
		{
			return true;
		}
		else
		{
			for(var ps : liste)
			{
				Date a = new Date(ps.dateDebutReservation.getYear(),ps.dateDebutReservation.getMonth(),ps.dateDebutReservation.getDate());
				Date b = new Date(ps.dateFinReservation.getYear(),ps.dateFinReservation.getMonth(),ps.dateFinReservation.getDate());
				Date d = new Date(this.dateFinReservation.getYear(),this.dateFinReservation.getMonth(),this.dateFinReservation.getDate());
				Date c = new Date(this.dateDebutReservation.getYear(),this.dateDebutReservation.getMonth(),this.dateDebutReservation.getDate());
				long aa = a.getTime();
				long bb = b.getTime();
				long cc = c.getTime();
				long dd = d.getTime();
				if((cc>aa&&cc<bb)||(dd>aa&&dd<bb)||(cc<aa&&dd>bb))
				{
						return false;
				}
				else
				{
					if(cc==aa && dd==bb)
					{
						return false;
					}
					else
					{
						verif=true;
					}
				}
			}
		}
		return verif;
	}
	public void creerPlanningSalle(Organisateur o)
	{
		planningSalleDAO.create(this);
	}
	
}
