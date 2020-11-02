package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import POJO.*;

public class ArtisteDAO extends DAO<Artiste> {
	public ArtisteDAO(Connection conn) {
		super(conn);
	}

	public boolean create(Artiste obj) {
		try {
			if(find(obj.getEmail())==null)
			{
				String insertion = "INSERT INTO Personne (Nom,Prenom,Adresse,Email,MotDePasse,Discriminator) "
						+ "values ('" + obj.getNom() + "','" + obj.getPrenom()+"','"+obj.getAdresse()+"','"+ obj.getEmail()+"','" + obj.getPassword()+ "','Artiste');";
				System.out.println(insertion);
				connect.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY).executeUpdate(insertion);	
			}
			else
			{
				System.out.println("L'objet existe déja");
			}
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean delete(Artiste obj) {
		try {
			if(find(obj.getEmail())!=null)
			{
				String delete = "DELETE FROM Artiste where artiste_id = "+obj.getId()+";";
				System.out.println(delete);
				connect.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY).executeUpdate(delete);	
			}
			else
			{
				System.out.println("L'objet n'existe pas");
			}
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Artiste obj) {
		try {
			if(find(obj.getEmail())!=null)
			{
				String update = "UPDATE Artiste set artiste_nom = '"+obj.getNom() +",artiste_prenom = '" + obj.getPrenom()+"',artiste_adresse = "+ obj.getAdresse()+ "' where artiste_id = "+obj.getId()+";";
				System.out.println(update);
				connect.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY).executeUpdate(update);	
			}
			else
			{
				System.out.println("L'objet n'existe pas");
			}
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public Artiste find(String email) {
		Artiste artiste = null;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM Personne WHERE Email = '"+ email + "';");
			if (result.first())
				artiste = new Artiste(result.getString("Nom"), result.getString("Prenom"), result.getString("Adresse"),result.getString("Email"),result.getString("MotDePasse"),result.getInt("IdPersonne"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return artiste;
	}
}
