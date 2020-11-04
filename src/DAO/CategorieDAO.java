package DAO;

import java.sql.Connection;

import POJO.Categorie;

public class CategorieDAO extends DAO<Categorie>{
	public CategorieDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Categorie obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Categorie obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Categorie obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Categorie find(int Id) {
		// TODO Auto-generated method stub
		return null;
	}
}
