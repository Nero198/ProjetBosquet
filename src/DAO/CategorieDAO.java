package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import POJO.Categorie;

public class CategorieDAO extends DAO<Categorie>{
	public CategorieDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Categorie obj) {
		try {
			PreparedStatement ps = null;
			String insertion2 = "INSERT INTO Categorie (Type,Prix,NombrePlaceDispo,NombrePlaceMax) VALUES (?,?,?,?)";
			ps = connect.prepareStatement(insertion2);
			connect.createStatement();
			ps.setString(1, obj.getType());
			ps.setDouble(2, obj.getPrix());
			ps.setInt(3, obj.getNbrPlaceDispo());
			ps.setInt(4, obj.getNbrPlaceMax());
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
	public boolean delete(Categorie obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Categorie obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Categorie find(int Id) {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean ajouterConfiguration(int Id)
	{
		try {
			String update = "UPDATE Categorie set IdConfiguration =" +Id+" where IdConfiguration =0";
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
