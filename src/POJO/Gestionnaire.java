package POJO;

import java.io.Serializable;
import java.util.List;

import DAO.AbstractDAOFactory;
import DAO.DAO;
import DAO.GestionnaireDAO;

public class Gestionnaire extends Personne implements Serializable{
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Gestionnaire> gestionnaireDAO = adf.getGestionnaireDAO();
	private static final long serialVersionUID = -4561257021111929741L;
	private List<PlanningSalle> planningSalle;
	public List<PlanningSalle> getPlanningSalle() {
		return planningSalle;
	}
	public void setPlanningSalle(List<PlanningSalle> planningSalle) {
		this.planningSalle = planningSalle;
	}
	
	public Gestionnaire(int id, String nom, String prenom, String adresse,List<PlanningSalle> planningSalle) {
		super(id, nom, prenom, adresse);
		// TODO Auto-generated constructor stub
		this.planningSalle=planningSalle;
	}
	public Gestionnaire(String nom, String prenom, String adresse, String email, String password) {
		super(nom, prenom, adresse, email, password);
		// TODO Auto-generated constructor stub
	}
	public Gestionnaire(String nom, String prenom, String adresse,List<PlanningSalle> planningSalle) {
		super(nom, prenom, adresse);
		// TODO Auto-generated constructor stub
		this.planningSalle=planningSalle;
	}
	public Gestionnaire(String nom, String prenom, String adresse, String email, String password, int id) {
		super(nom, prenom, adresse, email, password, id);
		// TODO Auto-generated constructor stub
	}
	public void getAllPlanningSalle()
	{
		List<PlanningSalle> planningSalles = ((GestionnaireDAO) gestionnaireDAO).find();
		this.setPlanningSalle(planningSalles);
	}

}
