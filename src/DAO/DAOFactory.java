package DAO;

import java.sql.Connection;

import POJO.Artiste;
import POJO.Categorie;
import POJO.Client;
import POJO.Commande;

public class DAOFactory extends AbstractDAOFactory {
	protected static final Connection conn = connection.ProjetConnection.getInstance();
	public DAO<Artiste> getArtisteDAO() {
		return new ArtisteDAO(conn);
	}
	public DAO<Client> getClientDAO() {
		return new ClientDAO(conn);
	}
	public DAO<Categorie> getCatetogieDAO() {
		return null;
	}
	public DAO<Commande> getCommandeDAO() {
		return null;
	}

}
