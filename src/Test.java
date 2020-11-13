
import java.sql.Date;
import java.text.SimpleDateFormat;

import DAO.*;
import POJO.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Organisateur a = new Organisateur("Versaevel","Florian","Courcelles","Versaevel.florian@hotmail.com","Test2019");
		Client a2 = new Client("Versaevel","Florian","Courcelles","Versaevel.test@hotmail.com","Test2019");
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		DAO<Artiste> artisteDAO = adf.getArtisteDAO();
		DAO<Client> clientDAO = adf.getClientDAO();
		DAO<Categorie> categorieDAO = adf.getCatetogieDAO();
		DAO<Commande> commandeDAO = adf.getCommandeDAO();
		DAO<Configuration> configurationDAO = adf.getConfigurationDAO();
		DAO<Gestionnaire> gestionnaireDAO = adf.getGestionnaireDAO();
		DAO<Organisateur> organisateurDAO = adf.getOrganisateurDAO();
		DAO<Place> placeDAO = adf.getPlaceDAO();
		DAO<PlanningSalle> planningSalleDAO = adf.getPlanningSalleDAO();
		DAO<Representation> representationDAO = adf.getRepresentationDAO();
		DAO<Reservation> reservationDAO = adf.getReservationDAO();
		DAO<Spectacle> spectacleDAO = adf.getSpectacleDAO();
		DAO<Personne> personneDAO = adf.getPersonneDAO();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		var test = ((PlanningSalleDAO)planningSalleDAO).find();
		for(var i : test)
		{
			System.out.println(i.getDateDebutReservation());
		}
		//((ReservationDAO) reservationDAO).ajoutOrganisateur(a);
		//Ps.verifierDisponibilite();
		//r.CalculerPrixSalle();
		/*PlanningSalle Ps;
		Date d1;
		Date d2;
		try {
		    d1 = dateFormat.parse("19/11/2020 12:00");
		    d2 = dateFormat.parse("25/11/2020 12:00:00");
		    System.out.print(d1);
			Ps = new PlanningSalle(d1,d2,null);
			planningSalleDAO.create(Ps);
		 } catch (ParseException ex) {
		    ex.printStackTrace();
		 }*/
	}

}
