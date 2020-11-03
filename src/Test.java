import DAO.*;
import POJO.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Artiste a = new Artiste("Versaevel","Florian","Courcelles","Versaevel.florian@hotmail.com","Test2019");
		Client a2 = new Client("Versaevel","Florian","Courcelles","Versaevel.test@hotmail.com","Test2019");
		AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
		DAO<Artiste> artisteDAO = adf.getArtisteDAO();
		DAO<Client> clientDAO = adf.getClientDAO();
		artisteDAO.create(a);
		clientDAO.create(a2);
		//Artiste b = ((ArtisteDAO)artisteDAO).find(a.getEmail());
		//System.out.println(b);
		//artisteDAO.delete(a);
		//artisteDAO.update(a2);
	}

}
