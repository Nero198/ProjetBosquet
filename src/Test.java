import DAO.*;
import POJO.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Artiste a = new Artiste("Versaevel","Florian","Courcelles","Versaevel.florian@hotmail.com","Test2019");
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
		artisteDAO.create(a);
		clientDAO.create(a2);
		//Artiste b = ((ArtisteDAO)artisteDAO).find(a.getEmail());
		//System.out.println(b);
		//artisteDAO.delete(a);
		//artisteDAO.update(a2);
	}

}
