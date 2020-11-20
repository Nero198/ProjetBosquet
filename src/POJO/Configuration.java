package POJO;

import java.io.Serializable;
import java.util.List;

import DAO.AbstractDAOFactory;
import DAO.ConfigurationDAO;
import DAO.DAO;

public class Configuration implements Serializable {
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	DAO<Configuration> configurationDAO = adf.getConfigurationDAO();
	private static final long serialVersionUID = -4080929672220860917L;
	private String type;
	private String description;
	private List<Categorie> categorie;
	private int Id;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Categorie> getCategorie() {
		return categorie;
	}
	public void setCategorie(List<Categorie> categorie) {
		this.categorie = categorie;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public Configuration(String type, String description, List<Categorie> categorie) {
		this.type = type;
		this.description = description;
		this.categorie = categorie;
	}
	
	public Configuration(String type, String description, int id) {
		this.type = type;
		this.description = description;
		Id = id;
	}
	public Configuration() {
	}
	@Override
	public String toString() {
		return "Configuration [type=" + type + ", description=" + description + ", categorie=" + categorie + "]";
	}
	public boolean ajouterConfiguration(int Id)
	{
		configurationDAO.create(this);
		((ConfigurationDAO)configurationDAO).ajouterSpectacle(Id);
		Configuration c = configurationDAO.find(Id);
		for(var i : this.categorie)
		{
			i.ajouterCategorie(c);
		}
		return true;
	}
	
}
