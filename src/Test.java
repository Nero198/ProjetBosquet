import DAO.*;
import POJO.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Artiste a = new Artiste("Versaevel","Florian","Courcelles","Versaevel.florian@hotmail.com","Test2019");
		Artiste a2 = new Artiste("Versaevel","Florian","Charleroi");
		DAO<Artiste> artisteDAO = new ArtisteDAO(Connection.ProjetConnection.getInstance());
		//artisteDAO.create(a);
		Artiste b = artisteDAO.find(a.getEmail());
		System.out.println(b);
		//artisteDAO.delete(a);
		//artisteDAO.update(a2);
	}

}
