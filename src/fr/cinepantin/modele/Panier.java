package fr.cinepantin.modele;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="panier")
public class Panier {

	@Id
	@Column (name="idPanier", nullable=false)
	private String id;
	
	@ManyToOne (fetch=FetchType.LAZY)
	@JoinColumn (name="Client_idClient")//jointure avec la table Client
	private Client client;
	
	@ManyToMany /*(fetch=FetchType.LAZY) */ // lien avec la table Article
	@JoinTable (
			name="lignes_commande",
			joinColumns={@JoinColumn(name="Panier_idPanier", referencedColumnName = "idPanier")},
			inverseJoinColumns={@JoinColumn(name="Article_idArticle", referencedColumnName ="idArticle")}
			)
	private List<Article> articles;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Panier(String id, Client client) {
		super();
		this.id = id;
		this.client = client;
	}
	public Panier (){
	}
}
