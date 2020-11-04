package DAO;

import java.sql.Connection;

import POJO.*;

public class DAOFactory extends AbstractDAOFactory {
	protected static final Connection conn = connection.ProjetConnection.getInstance();
	public DAO<Artiste> getArtisteDAO() {
		return new ArtisteDAO(conn);
	}
	public DAO<Client> getClientDAO() {
		return new ClientDAO(conn);
	}
	public DAO<Categorie> getCatetogieDAO() {
		return new CategorieDAO(conn);
	}
	public DAO<Commande> getCommandeDAO() {
		return new CommandeDAO(conn);
	}
	public DAO<Configuration> getConfigurationDAO(){
		return new ConfigurationDAO(conn);
	}
	public DAO<Gestionnaire> getGestionnaireDAO(){
		return new GestionnaireDAO(conn);
	}
	public DAO<Organisateur> getOrganisateurDAO(){
		return new OrganisateurDAO(conn);
	}
	public DAO<Place> getPlaceDAO(){
		return new PlaceDAO(conn);
	}
	public DAO<PlanningSalle> getPlanningSalleDAO(){
		return new PlanningSalleDAO(conn);
	}
	public DAO<Representation> getRepresentationDAO(){
		return new RepresentationDAO(conn);
	}
	public DAO<Reservation> getReservationDAO(){
		return new ReservationDAO(conn);
	}
	public DAO<Spectacle> getSpectacleDAO(){
		return new SpectacleDAO(conn);
	}
	public DAO<Personne> getPersonneDAO(){
		return new PersonneDAO(conn);
	}

}
