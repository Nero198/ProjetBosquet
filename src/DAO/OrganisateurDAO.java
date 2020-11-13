package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import POJO.Organisateur;

public class OrganisateurDAO extends DAO<Organisateur> {
	public OrganisateurDAO(Connection conn) {
		super(conn);
	}

	public boolean create(Organisateur obj) {
		try {
			if(find(obj.getEmail())==null)
			{
				String insertion = "INSERT INTO Personne (Nom,Prenom,Adresse,Email,MotDePasse,Discriminator) "
						+ "values ('" + obj.getNom() + "','" + obj.getPrenom()+"','"+obj.getAdresse()+"','"+ obj.getEmail()+"','" + obj.getPassword()+ "','Organisateur');";
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

	public boolean delete(Organisateur obj) {
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

	public boolean update(Organisateur obj) {
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

	public Organisateur find(int Id) {
		Organisateur organisateur = null;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM Personne WHERE IdPersonne = "+ Id + ";");
			if (result.first())
				organisateur = new Organisateur(result.getString("Nom"), result.getString("Prenom"), result.getString("Adresse"),result.getString("Email"),result.getString("MotDePasse"),result.getInt("IdPersonne"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return organisateur;
	}
	public Organisateur find(String Email) {
		System.out.print("Recherche de l'orga");
		Organisateur organisateur = null;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM Personne WHERE Email = '"+ Email + "';");
			if (result.first())
				organisateur = new Organisateur(result.getString("Nom"), result.getString("Prenom"), result.getString("Adresse"),result.getString("Email"),result.getString("MotDePasse"),result.getInt("IdPersonne"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return organisateur;
	}
}
