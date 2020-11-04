package DAO;

import java.sql.Connection;

import POJO.Categorie;
import POJO.Commande;

public class CommandeDAO extends DAO<Commande>{
	public CommandeDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Commande obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Commande obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Commande obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Commande find(int Id) {
		// TODO Auto-generated method stub
		return null;
	}
}
