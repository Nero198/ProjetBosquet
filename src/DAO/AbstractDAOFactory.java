package DAO;

import POJO.*;

public abstract class AbstractDAOFactory {
	public static final int DAO_FACTORY = 0;
	public static final int XML_DAO_FACTORY = 1;
	
	public abstract DAO<Artiste> getArtisteDAO();
	
	public abstract DAO<Client> getClientDAO();
	
	public abstract DAO<Categorie> getCatetogieDAO();
		
	public abstract DAO<Commande> getCommandeDAO();
	
	public static AbstractDAOFactory getFactory(int type){
		switch(type){
		case DAO_FACTORY:
			return new DAOFactory();
			default:
				return null;
		}
	}
}


