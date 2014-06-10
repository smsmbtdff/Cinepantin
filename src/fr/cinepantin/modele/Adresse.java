package fr.cinepantin.modele;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table (name="adresses")
public class Adresse {

	@Id
	@Column (name="idAdresse", nullable=false)
	private String id;
	
	@Column (name="numero")
	private int numero;
	
	@Column (name="rue")
	private String rue;
	
	@Column (name="ville")
	private String ville;
	
	@Column (name="codePostal")
	private int codePostal;
	
	@ManyToMany
	(mappedBy ="adresse")//lien avec la table Client
	private List<Client> client; 
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public List<Client> getClient() {
		return client;
	}

	public void setClient(List<Client> client) {
		this.client = client;
	}

	public Adresse(){
		
	}
	

}
