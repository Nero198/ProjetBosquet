package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import POJO.PlanningSalle;

public class PlanningSalleDAO extends DAO<PlanningSalle>{

	public PlanningSalleDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean create(PlanningSalle obj) {
		try {
			PreparedStatement ps = null;
			String insertion2 = "INSERT INTO PlanningSalle (DateDebut,DateFin) VALUES (?,?)";
			ps = connect.prepareStatement(insertion2);
			Timestamp dateDebut = new Timestamp(obj.getDateDebutReservation().getYear(),obj.getDateDebutReservation().getMonth(),obj.getDateDebutReservation().getDate(),12,0,0,0);
			Timestamp dateFin = new Timestamp(obj.getDateFinReservation().getYear(),obj.getDateFinReservation().getMonth(),obj.getDateFinReservation().getDate(),12,0,0,0);
			connect.createStatement();
			ps.setTimestamp(1, dateDebut);
			ps.setTimestamp(2, dateFin);
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
					PlanningSalle PS = new PlanningSalle(result.getDate("DateDebut"),result.getDate("DateFin"),null,result.getInt("IdSalle"));
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
			System.out.print("Find By Date");
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String query = "SELECT * from PlanningSalle where (DateDebut = " + dateFormat.format(ps.getDateDebutReservation()) +")";
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery(query);
			id = result.getInt("IdSalle");
			System.out.println(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
}
