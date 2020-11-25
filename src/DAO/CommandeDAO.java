package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import POJO.Client;
import POJO.Commande;

public class CommandeDAO extends DAO<Commande> {
	public CommandeDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Commande obj) {
		try {
			String insertion = "INSERT INTO Commande (ModeLivraison,ModePayement,CoutTotal) values ('"
					+ obj.getModeLivraison() + "','" + obj.getModePayement() + "','" + obj.getCout() + "')";
			System.out.println(insertion);
			connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeUpdate(insertion);
			String update = "Update Place set IdCommande = (Select IdCommande from Commande where(ModeLivraison ='"
					+ obj.getModeLivraison() + "' AND ModePayement = '" + obj.getModePayement() + "' AND CoutTotal = '"
					+ obj.getCout() + "'))";
			connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
			.executeUpdate(update);
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Commande obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Commande obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Commande find(int Id) {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean ajouterClient(Client cli)
	{
		try {
			String update = "UPDATE Commande set IdPersonne =" +cli.getId()+" where IdPersonne=0";
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
