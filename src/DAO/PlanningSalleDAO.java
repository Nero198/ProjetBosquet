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
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			String insertion2 = "INSERT INTO PlanningSalle (DateDebut,DateFin,IdOrganisateur) VALUES (?,?,?)";
			
			/*String insertion = "INSERT INTO PlanningSalle (DateDebut,DateFin,IdOrganisateur) VALUES (#" + dateFormat.format(obj.getDateDebutReservation()) + "#,#" + dateFormat.format(obj.getDateFinReservation())+"#,12)";
			System.out.println(insertion);
			connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeUpdate(insertion);*/
			ps = connect.prepareStatement(insertion2);
			connect.createStatement();
			ps.setDate(1, (java.sql.Date)obj.getDateDebutReservation());
			ps.setDate(2, (java.sql.Date)obj.getDateFinReservation());
			ps.setInt(3, 12);
			ps.executeUpdate();
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

}
