package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import POJO.Configuration;

public class ConfigurationDAO extends DAO<Configuration> {

	public ConfigurationDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Configuration obj) {
		try {
			PreparedStatement ps = null;
			String insertion2 = "INSERT INTO Configuration (Type,Description) VALUES (?,?)";
			ps = connect.prepareStatement(insertion2);
			connect.createStatement();
			ps.setString(1, obj.getType());
			ps.setString(2, obj.getDescription());
			ps.executeUpdate();
			System.out.print(insertion2);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
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
		Configuration config = null;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM Configuration WHERE IdSpectacle = '"+ Id + "';");
			if(result.first())
			{
				config = new Configuration(result.getString("Type"),result.getString("Description"),result.getInt("IdConfiguration"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return config;
	}
	public boolean ajouterSpectacle(int Id)
	{
		try {
			String update = "UPDATE Configuration set IdSpectacle =" +Id+" where IdSpectacle =0";
			System.out.println(update);
			connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeUpdate(update);	
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
