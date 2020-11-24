package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import POJO.*;

public class RepresentationDAO extends DAO<Representation> {

	public RepresentationDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Representation obj) {
		try {
			PreparedStatement ps = null;
			String insertion2 = "INSERT INTO Representation (Date,HeureDebut,HeureFin,HeureOuverture,IdSpectacle) VALUES (?,?,?,?,?)";
			ps = connect.prepareStatement(insertion2);
			connect.createStatement();
			ps.setDate(1,  (java.sql.Date)obj.getDate());
			ps.setTimestamp(2, (Timestamp) obj.getHeureDebut());
			ps.setTimestamp(3, (Timestamp) obj.getHeureFin());
			ps.setTimestamp(4, (Timestamp) obj.getHeureOuverture());
			ps.setInt(5, obj.getSpectacle().getIdSpectacle());
			System.out.print(insertion2);
			ps.executeUpdate();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Representation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Representation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Representation find(int Id) {
		Representation r = new Representation();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM Representation WHERE IdRepresentation ="+Id  );
			if(result.first())
				r = new Representation(result.getDate("Date"),result.getTimestamp("HeureDebut"),result.getTimestamp("HeureFin"),result.getTimestamp("HeureOuverture"),result.getInt("IdRepresentation"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	public PlanningSalle getDateReservation(Spectacle s) {
		PlanningSalle planningSalle = null;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(
							"SELECT * FROM PlanningSalle p inner join Spectacle s on p.IdSalle = s.IdSalle WHERE IdSpectacle = '"
									+ s.getIdSpectacle() + "';");
			if (result.first())
				planningSalle = new PlanningSalle(result.getDate("DateDebut"), result.getDate("DateFin"), null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return planningSalle;
	}
	public List<Representation> getAll(int Id)
	{
		List<Representation> listes = new ArrayList<Representation>();
		try {
			String query = "SELECT * from Representation where (IdSpectacle = " + Id +")";
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery(query);
			while(result.next()) {
				Representation tuple = new Representation(result.getDate("Date"),result.getTimestamp("HeureDebut"),result.getTimestamp("HeureFin"),result.getTimestamp("HeureOuverture"),result.getInt("IdRepresentation"));
				listes.add(tuple);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listes;
	}
	
}
