package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Other.Tuple;
import POJO.Artiste;
import POJO.Client;
import POJO.Gestionnaire;
import POJO.Organisateur;
import POJO.Personne;
import POJO.Spectacle;

public class SpectacleDAO extends DAO<Spectacle>{

	public SpectacleDAO(Connection conn) {
		super(conn);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean create(Spectacle obj) {
		try {
			PreparedStatement ps = null;
			String insertion2 = "INSERT INTO Spectacle (Titre,NbrePlaceMax) VALUES (?,?)";
			ps = connect.prepareStatement(insertion2);
			connect.createStatement();
			ps.setString(1, obj.getTitre());
			ps.setInt(2, obj.getNbrPlaceParClient());
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
	public boolean delete(Spectacle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Spectacle obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Spectacle find(int Id) {
		Spectacle s = new Spectacle();
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM spectacle WHERE IdSpectacle ="+Id  );
			if(result.first())
				s = new Spectacle(result.getString("Titre"),null,result.getInt("NbrePlaceMax"),null,null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}
	public boolean ajoutDeLaSalle(int Id)
	{
		try {
			String update = "UPDATE spectacle set IdSalle =" +Id+" where IdSalle=0";
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
	public int getId(Spectacle spectacle,int IdSalle)
	{
		int i = 0;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM spectacle WHERE (Titre = '"+ spectacle.getTitre() + "' and IdSalle = '" + IdSalle +"');");
			if(result.first())
				i = result.getInt("IdSpectacle");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	public Boolean ajoutArtisteSpectacle(int idSpectacle,int idArtiste)
	{
		try {
			String insertion = "INSERT INTO ArtisteSpectacle (IdArtiste,IdSpectacle) VALUES ('"+ idArtiste + "','"+ idSpectacle+"')";
			System.out.println(idSpectacle + " " + idArtiste);
			System.out.println(insertion);
			connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeUpdate(insertion);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Tuple> getAll()
	{
		List<Tuple> tuples = new ArrayList<Tuple>();
		try {

			String query = "SELECT * from Spectacle s inner join PlanningSalle p on p.IdSalle=s.IdSalle";
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery(query);
				while(result.next()) {
					Tuple<Integer,String,Date,Date> tuple = new Tuple(result.getInt("IdSpectacle"), result.getString("Titre"), result.getDate("DateDebut"),
							result.getDate("DateFin"));
					tuples.add(tuple);
				}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tuples;
	}
	
}
