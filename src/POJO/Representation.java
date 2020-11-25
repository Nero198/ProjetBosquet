package POJO;

import java.io.Serializable;
import java.util.Date;

import DAO.AbstractDAOFactory;
import DAO.DAO;
import DAO.RepresentationDAO;

public class Representation implements Serializable {
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Representation> representationDAO = adf.getRepresentationDAO();
	private static final long serialVersionUID = -2923681938515090757L;
	private Date date;
	private Spectacle spectacle;
	private Date heureDebut;
	private Date heureFin;
	private Date heureOuverture;
	private int IdRepresentation;
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
	public Date getHeureOuverture() {
		return heureOuverture;
	}
	public void setHeureOuverture(Date heureOuverture) {
		this.heureOuverture = heureOuverture;
	}
	public int getIdRepresentation() {
		return IdRepresentation;
	}
	public void setIdRepresentation(int idRepresentation) {
		IdRepresentation = idRepresentation;
	}
	public Representation(Date date, Spectacle spectacle, Date heureDebut, Date heureFin) {
		this.date = date;
		this.spectacle = spectacle;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
	}
	public Representation(Date date, Spectacle spectacle, Date heureDebut, Date heureFin, Date heureOuverture) {
		this.date = date;
		this.spectacle = spectacle;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.heureOuverture = heureOuverture;
	}
	public Representation(Date date, Date heureDebut, Date heureFin, Date heureOuverture,int Id) {
		this.date = date;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.heureOuverture = heureOuverture;
		this.IdRepresentation=Id;
	}
	public Representation() {
	}
	public boolean verifierHeure()
	{
		
		PlanningSalle ps = ((RepresentationDAO)representationDAO).getDateReservation(this.getSpectacle());
		if(this.heureOuverture.before(this.heureDebut))
		{
			if(this.heureDebut.before(this.heureFin))
			{
				if(this.heureOuverture.after(ps.getDateDebutReservation()))
				{
					if(this.heureFin.before(ps.getDateFinReservation()))
						return true;
					else
						return false;
				}
				else
					return false;
			}
			else
				return false;
		}
		else
			return false;
	}
	public boolean ajouterRepresentation()
	{
		representationDAO.create(this);
		return true;
	}
}
