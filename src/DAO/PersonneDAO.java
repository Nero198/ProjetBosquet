package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import POJO.*;

public class PersonneDAO extends DAO<Personne>{
	public PersonneDAO(Connection conn) {
		super(conn);
	}

	public boolean create(Personne obj) {
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

	public boolean delete(Personne obj) {
		try {
			if(find(obj.getEmail())!=null)
			{
				String delete = "DELETE FROM Personne where IdPersonne = "+obj.getId()+";";
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

	public boolean update(Personne obj) {
		try {
			if(find(obj.getId())!=null)
			{
				String update = "UPDATE Personne set Nom = '"+obj.getNom() +",Prenom = '" + obj.getPrenom()+"',Adresse = "+ obj.getAdresse()+ "' where Email = "+obj.getEmail()+";";
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

	public Personne find(int Id) {
		Personne personne = null;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM Personne WHERE IdPersonne = "+ Id + ";");
			
			if (result.first())
			{
				switch(result.getString("Discriminator"))
				{
				case "Artiste" : personne = new Artiste (result.getString("Nom"), result.getString("Prenom"), result.getString("Adresse"),result.getString("Email"),result.getString("MotDePasse"),result.getInt("IdPersonne"));
					break;
				case "Organisateur" : personne = new Organisateur (result.getString("Nom"), result.getString("Prenom"), result.getString("Adresse"),result.getString("Email"),result.getString("MotDePasse"),result.getInt("IdPersonne"));
					break;			
				case "Gestionnaire" : personne = new Gestionnaire (result.getString("Nom"), result.getString("Prenom"), result.getString("Adresse"),result.getString("Email"),result.getString("MotDePasse"),result.getInt("IdPersonne"));
					break;
				default : personne = new Client (result.getString("Nom"), result.getString("Prenom"), result.getString("Adresse"),result.getString("Email"),result.getString("MotDePasse"),result.getInt("IdPersonne"));
					break;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return personne;
	}
	public Personne find(String Email) {
		Personne personne = null;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM Personne WHERE Email = '"+ Email + "';");
			if (result.first())
				switch(result.getString("Discriminator"))
				{
				case "Artiste" : personne = new Artiste (result.getString("Nom"), result.getString("Prenom"), result.getString("Adresse"),result.getString("Email"),result.getString("MotDePasse"),result.getInt("IdPersonne"));
					break;
				case "Organisateur" : personne = new Organisateur (result.getString("Nom"), result.getString("Prenom"), result.getString("Adresse"),result.getString("Email"),result.getString("MotDePasse"),result.getInt("IdPersonne"));
					break;
				case "Gestionnaire" : personne = new Gestionnaire (result.getString("Nom"), result.getString("Prenom"), result.getString("Adresse"),result.getString("Email"),result.getString("MotDePasse"),result.getInt("IdPersonne"));
					break;
				default : personne = new Client (result.getString("Nom"), result.getString("Prenom"), result.getString("Adresse"),result.getString("Email"),result.getString("MotDePasse"),result.getInt("IdPersonne"));
					break;
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return personne;
	}
}
