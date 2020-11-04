package DAO;

import java.sql.Connection;

import POJO.Spectacle;

public class SpectacleDAO extends DAO<Spectacle>{

	public SpectacleDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Spectacle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Spectacle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Spectacle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Spectacle find(int Id) {
		// TODO Auto-generated method stub
		return null;
	}

}
