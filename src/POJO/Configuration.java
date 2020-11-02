package POJO;

import java.io.Serializable;

public class Configuration implements Serializable {
	
	private static final long serialVersionUID = -4080929672220860917L;
	private String type;
	private String description;
	private Categorie categorie;
	
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
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public Configuration(String type, String description, Categorie categorie) {
		this.type = type;
		this.description = description;
		this.categorie = categorie;
	}
}
