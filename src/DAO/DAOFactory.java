package DAO;

import java.sql.Connection;

import POJO.Artiste;
import POJO.Categorie;
import POJO.Client;
import POJO.Commande;

public class DAOFactory extends AbstractDAOFactory {
	protected static final Connection conn = connection.ProjetConnection.getInstance();
	@Override
	public DAO<Artiste> getArtisteDAO() {
		return new ArtisteDAO(conn);
	}

	@Override
	public DAO<Client> getClientDAO() {
		return null;
	}

	@Override
	public DAO<Categorie> getCatetogieDAO() {
		return null;
	}

	@Override
	public DAO<Commande> getCommandeDAO() {
		return null;
	}

}
