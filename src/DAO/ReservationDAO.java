package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import POJO.Organisateur;
import POJO.Reservation;

public class ReservationDAO extends DAO<Reservation>{

	public ReservationDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Reservation obj) {
		try {
			PreparedStatement ps = null;
			String insertion2 = "INSERT INTO Reservation (Solde,IdSalle,IdOrganisateur,Statut,Accompte,Prix) VALUES (?,?,?,?,?,?)";
			ps = connect.prepareStatement(insertion2);
			connect.createStatement();
			ps.setInt(1, obj.getSolde());
			var planningSalle = obj.getPlanningSalle();
			int idSalle = planningSalle.find();
			ps.setInt(2, idSalle);
			ps.setString(4, obj.getStatut());
			ps.setInt(5, obj.getAccompte());			
			ps.setInt(6, obj.getPrix());
			ps.executeUpdate();
			System.out.print(insertion2);
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Reservation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Reservation obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Reservation find(int Id) {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean ajoutOrganisateur(Organisateur o) {
		try {
			String update = "UPDATE Reservation set IdOrganisateur =" +o.getId()+" where IdOrganisateur is null";
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
