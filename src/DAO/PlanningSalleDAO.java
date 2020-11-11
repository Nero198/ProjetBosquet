package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import POJO.Artiste;
import POJO.PlanningSalle;

public class PlanningSalleDAO extends DAO<PlanningSalle>{

	public PlanningSalleDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(PlanningSalle obj) {
		try {
			PreparedStatement ps = null;
			String insertion2 = "INSERT INTO PlanningSalle (DateDebut,DateFin) VALUES (?,?)";
			ps = connect.prepareStatement(insertion2);
			connect.createStatement();
			ps.setDate(1, (java.sql.Date)obj.getDateDebutReservation());
			ps.setDate(2, (java.sql.Date)obj.getDateFinReservation());
			ps.executeUpdate();
			System.out.print(insertion2);
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(PlanningSalle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(PlanningSalle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PlanningSalle find(int Id) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<PlanningSalle> find()
	{
		List<PlanningSalle> PlanningSalle = new ArrayList<PlanningSalle>();
		try {

			String query = "SELECT * from PlanningSalle";
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery(query);
				while(result.next()) {
					PlanningSalle PS = new PlanningSalle(result.getDate("DateDebut"),result.getDate("DateFin"),null);
					PlanningSalle.add(PS);
				}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return PlanningSalle;
	}
	public int findByDate(PlanningSalle ps)
	{
		int id=0;
		try {

			String query = "SELECT * from PlanningSalle where (DateDebut = " + ps.getDateDebutReservation() +") and (DateFin = "+ps.getDateFinReservation()+")";
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery(query);
			id = result.getInt("IdSalle");
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
}
