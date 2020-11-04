package DAO;

import java.sql.Connection;

import POJO.Place;

public class PlaceDAO extends DAO<Place>{

	public PlaceDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Place obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Place obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Place obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Place find(int Id) {
		// TODO Auto-generated method stub
		return null;
	}

}
