package POJO;

import java.io.Serializable;
import java.util.*;

public class Spectacle implements Serializable{
	
	private static final long serialVersionUID = 2873764636877910333L;
	private String titre;
	private List<Artiste> Artistes;
	private int nbrPlaceParClient;
	private Configuration configuration;
	private List<Representation> representations;
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public List<Artiste> getArtistes() {
		return Artistes;
	}
	public void setArtistes(List<Artiste> artistes) {
		Artistes = artistes;
	}
	public int getNbrPlaceParClient() {
		return nbrPlaceParClient;
	}
	public void setNbrPlaceParClient(int nbrPlaceParClient) {
		this.nbrPlaceParClient = nbrPlaceParClient;
	}
	public Configuration getConfiguration() {
		return configuration;
	}
	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}
	public List<Representation> getRepresentations() {
		return representations;
	}
	public void setRepresentations(List<Representation> representations) {
		this.representations = representations;
	}
	public Spectacle(String titre, List<Artiste> artistes, int nbrPlaceParClient, Configuration configuration,
			List<Representation> representations) {
		this.titre = titre;
		Artistes = artistes;
		this.nbrPlaceParClient = nbrPlaceParClient;
		this.configuration = configuration;
		this.representations = representations;
	}
}
