package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import POJO.Place;
import POJO.Representation;

public class PlaceDAO extends DAO<Place> {

	public PlaceDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Place obj) {
		try {
			String insertion = "INSERT INTO Place (Prix,IdRepresentation) " + "values (" + obj.getPrix() + ","
					+ obj.getRepresentation().getIdRepresentation() + ")";
			System.out.println(insertion);
			connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeUpdate(insertion);
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
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
	public List<Place> getAll()
	{
		List<Place> listes = new ArrayList<Place>();
		try {
			String query = "SELECT * from Place p inner join Representation r on p.IdRepresentation = r.IdRepresentation where (IdCommande = 0)";
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery(query);
			while(result.next()) {
				Place tuple = new Place(0,result.getDouble("Prix"),new Representation(result.getDate("Date"),result.getTimestamp("HeureDebut"),result.getTimestamp("HeureFin"),result.getTimestamp("HeureOuverture"),result.getInt("IdRepresentation")));
				listes.add(tuple);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listes;
	}

}
