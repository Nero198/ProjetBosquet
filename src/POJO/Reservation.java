package POJO;

import java.io.Serializable;
import java.util.Date;
import DAO.AbstractDAOFactory;
import DAO.DAO;
import DAO.OrganisateurDAO;
import DAO.PersonneDAO;
import DAO.ReservationDAO;
public class Reservation implements Serializable {
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Reservation> reservationDAO = adf.getReservationDAO();
	private static final long serialVersionUID = 7982945450646152881L;
	private int accompte;
	private int solde;
	private String statut;
	private int prix;
	private PlanningSalle planningSalle;
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
	public PlanningSalle getPlanningSalle() {
		return planningSalle;
	}
	public void setPlanningSale(PlanningSalle planningSalle) {
		this.planningSalle = planningSalle;
	}
	public Reservation(int accompte, int solde, String statut, int prix, PlanningSalle planningSalle) {
		this.accompte = accompte;
		this.solde = solde;
		this.statut = statut;
		this.prix = prix;
		this.planningSalle = planningSalle;
	}
	
	public Reservation() {
		// TODO Auto-generated constructor stub
	}
	public void calculerPrixSalle()
	{
		this.prix=this.accompte;
		int cpt=0;
		Date date=new Date();
		date=this.planningSalle.getDateDebutReservation();
		do
		{
			if(date.getDay()-1>=0 && date.getDay()-1<5)
			{
				this.prix+=3000;
			}
			else
			{
				this.prix+=4500;
			}
			date.setDate(date.getDate()+1);
			cpt++;
		}while(date.before(this.planningSalle.getDateFinReservation()));
		date.setDate(date.getDate()-cpt);
		if(cpt==2)
			this.prix*=0.95;
		else if(cpt>=3 && cpt<7)
			this.prix*=0.9;
		else if(cpt>=7 && cpt<15)
			this.prix*=0.80;
		else if(cpt>=15)
			this.prix*=0.7;
		this.solde=this.prix-this.accompte;
	}
	public void creerReservation(Organisateur o) {
		this.planningSalle.creerPlanningSalle();
		reservationDAO.create(this);
		((ReservationDAO) reservationDAO).ajoutOrganisateur(o);
	}
	@Override
	public String toString() {
		return "Reservation [accompte=" + accompte + ", solde=" + solde + ", statut=" + statut + ", prix=" + prix
				+ ", planningSalle=" + planningSalle + "]";
	}
	
}
