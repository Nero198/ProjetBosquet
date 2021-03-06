package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import POJO.*;

public class ArtisteDAO extends DAO<Artiste> {
	public ArtisteDAO(Connection conn) {
		super(conn);
	}

	public boolean create(Artiste obj) {
		try {
			if (find(obj.getEmail()) == null) {
				String insertion = "INSERT INTO Personne (Nom,Prenom,Adresse,Email,MotDePasse,Discriminator) "
						+ "values ('" + obj.getNom() + "','" + obj.getPrenom() + "','" + obj.getAdresse() + "','"
						+ obj.getEmail() + "','" + obj.getPassword() + "','Artiste');";
				System.out.println(insertion);
				connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
						.executeUpdate(insertion);
			} else {
				System.out.println("L'objet existe d�ja");
			}
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean delete(Artiste obj) {
		try {
			if (find(obj.getEmail()) != null) {
				String delete = "DELETE FROM Personne where IdPersonne = " + obj.getId() + ";";
				System.out.println(delete);
				connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
						.executeUpdate(delete);
			} else {
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
			if (find(obj.getId()) != null) {
				String update = "UPDATE Personne set Nom = '" + obj.getNom() + ",Prenom = '" + obj.getPrenom()
						+ "',Adresse = " + obj.getAdresse() + "' where Email = " + obj.getEmail() + ";";
				System.out.println(update);
				connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
						.executeUpdate(update);
			} else {
				System.out.println("L'objet n'existe pas");
			}
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public Artiste find(int Id) {
		Artiste artiste = null;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM Personne WHERE IdPersonne = " + Id + ";");
			if (result.first())
				artiste = new Artiste(result.getString("Nom"), result.getString("Prenom"), result.getString("Adresse"),
						result.getString("Email"), result.getString("MotDePasse"), result.getInt("IdPersonne"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return artiste;
	}

	public Artiste find(String Email) {
		Artiste artiste = null;
		try {
			ResultSet result = this.connect
					.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery("SELECT * FROM Personne WHERE Email = '" + Email + "';");
			if (result.first())
				artiste = new Artiste(result.getString("Nom"), result.getString("Prenom"), result.getString("Adresse"),
						result.getString("Email"), result.getString("MotDePasse"), result.getInt("IdPersonne"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return artiste;
	}

	public List<Artiste> find() {
		List<Artiste> artistes = new ArrayList<Artiste>();
		try {

			String query = "SELECT * from Personne where Discriminator ='Artiste'";
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)
					.executeQuery(query);
				while(result.next()) {
					Artiste artiste = new Artiste(result.getString("Nom"), result.getString("Prenom"), result.getString("Adresse"),
							result.getString("Email"), result.getString("MotDePasse"), result.getInt("IdPersonne"));
					artistes.add(artiste);
				}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return artistes;
	}
}
