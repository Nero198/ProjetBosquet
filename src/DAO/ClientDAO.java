package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import POJO.Client;
import POJO.Commande;

public class ClientDAO extends DAO<Client> {
	public ClientDAO(Connection conn) {
		super(conn);
	}

	public boolean create(Client obj) {
		try {
			if(find(obj.getEmail())==null)
			{
				String insertion = "INSERT INTO Personne (Nom,Prenom,Adresse,Email,MotDePasse,Discriminator) "
						+ "values ('" + obj.getNom() + "','" + obj.getPrenom()+"','"+obj.getAdresse()+"','"+ obj.getEmail()+"','" + obj.getPassword()+ "','Client');";
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

	public boolean delete(Client obj) {
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

	public boolean update(Client obj) {
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

	public Client find(int Id) {
		Client client = null;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM Personne WHERE IdPersonne = "+ Id + ";");
			if (result.first())
				client = new Client(result.getString("Nom"), result.getString("Prenom"), result.getString("Adresse"),result.getString("Email"),result.getString("MotDePasse"),result.getInt("IdPersonne"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return client;
	}
	public Client find(String Email) {
		Client client = null;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM Personne WHERE Email = '"+ Email + "';");
			if (result.first())
				client = new Client(result.getString("Nom"), result.getString("Prenom"), result.getString("Adresse"),result.getString("Email"),result.getString("MotDePasse"),result.getInt("IdPersonne"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return client;
	}
	public List<Commande> getAll(int id)
	{
		List<Commande> listes = new ArrayList<Commande>();
		try {
			String query = "SELECT * from Commande where (IdPersonne = " + id +")";
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery(query);
			while(result.next()) {
				Commande tuple = new Commande(result.getString("ModePayement"),result.getString("ModeLivraison"),result.getDouble("CoutTotal"),null);
				listes.add(tuple);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listes;
	}
}
