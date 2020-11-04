package DAO;

import java.sql.Connection;

import POJO.Configuration;

public class ConfigurationDAO extends DAO<Configuration> {

	public ConfigurationDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Configuration obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Configuration obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Configuration obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Configuration find(int Id) {
		// TODO Auto-generated method stub
		return null;
	}

}
