package fr.cinepantin.modele;

import java.util.List;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table (name="commande")
public class Commande {
	
	@Id
	@Column (name="idcommande", nullable =false)
	private String id;
	
	@Column (name="dateCommande")
	@Temporal(TemporalType.DATE)
	private Date dateCommande;
	
	//jointure avec la table Client
	@ManyToOne (fetch=FetchType.LAZY)
	@JoinColumn (name="Client_idClient")
	private Client client;

	@ManyToMany /*(fetch=FetchType.LAZY) */ // lien avec la table Article
	@JoinTable (
			name="lignes_commande",
			joinColumns={@JoinColumn(name="commande_idcommande", referencedColumnName = "idcommande")},
			inverseJoinColumns={@JoinColumn(name="Article_idArticle", referencedColumnName ="idArticle")}
			)
	private List<Article> articles;
	
	public Date getDateCommande() {
		return dateCommande;
	}
	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	public Commande(String id, Date datenaissance) {
		super();
		this.id = id;
		this.dateCommande = datenaissance;
	}
	public Commande() {//constructeur vide
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getDatenaissance() {
		return dateCommande;
	}
	public void setDatenaissance(Date datenaissance) {
		this.dateCommande = datenaissance;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	
}
