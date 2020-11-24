package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import POJO.Organisateur;
import POJO.PlanningSalle;
import POJO.Reservation;
import POJO.Spectacle;

public class ReservationDAO extends DAO<Reservation> {

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
			ps.setDouble(1, obj.getSolde());
			var planningSalle = obj.getPlanningSalle();
			int idSalle = planningSalle.find();
			System.out.println(idSalle);
			ps.setInt(2, idSalle);
			ps.setInt(3, 0);
			ps.setString(4, "Payé");
			System.out.print("payé");
			ps.setDouble(5, obj.getAccompte());
			ps.setDouble(6, obj.getPrix());
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
			System.out.print("Ajout de l'orga");
			String update = "UPDATE Reservation set IdOrganisateur =" + o.getId() + " where IdOrganisateur = 0";
			System.out.println(update);
			connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeUpdate(update);
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Reservation> findAll(int Id) {
		List<Reservation> liste = new ArrayList<>();
		List<Spectacle> liste2 = new ArrayList<>();
		List<Spectacle> liste3 = new ArrayList<>();
		try {

			ResultSet result2 = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(
							"SELECT * FROM Reservation r inner Join PlanningSalle p on r.IdSalle=p.IdSalle inner join Spectacle s on p.IdSalle = s.IdSalle WHERE IdOrganisateur ="
									+ Id);
			while (result2.next()) {
				liste2 = new ArrayList<>();
				Reservation r = new Reservation(result2.getInt("Accompte"), result2.getInt("Solde"),
						result2.getString("Statut"), result2.getInt("Prix"),
						new PlanningSalle(result2.getTimestamp("DateDebut"), result2.getTimestamp("DateFin"), liste2,result2.getInt("IdSalle")));
					r.getPlanningSalle().getSpectacle().add(new Spectacle(result2.getString("Titre"),result2.getInt("IdSpectacle")));
				
				liste.add(r);
			}
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(
							"SELECT * FROM Reservation r inner Join PlanningSalle p on r.IdSalle=p.IdSalle left join Spectacle s on p.IdSalle = s.IdSalle WHERE (IdOrganisateur ="
									+ Id+" AND s.IdSalle is NULL)");
			while (result.next()) {
				liste2 = new ArrayList<>();
				Reservation r = new Reservation(result.getInt("Accompte"), result.getInt("Solde"),
						result.getString("Statut"), result.getInt("Prix"),
						new PlanningSalle(result.getTimestamp("DateDebut"), result.getTimestamp("DateFin"), liste2,result.getInt("IdSalle")));
					r.getPlanningSalle().getSpectacle().add(new Spectacle());
				
				liste.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return liste;
	}

}
