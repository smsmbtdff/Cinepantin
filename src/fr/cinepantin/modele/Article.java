package fr.cinepantin.modele;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Article {
	
	@Id
	@Column (name="idArticle")
	private String id;
	
	@ManyToOne (fetch=FetchType.LAZY)
	@JoinColumn (name="Prix_idPrix")
	private Prix prix;
	
	@ManyToOne (fetch=FetchType.LAZY)
	@JoinColumn (name="Stock_idStock")
	private Stock etatStock;
	
	@ManyToMany
	(mappedBy = "articles")
	private List<Commande> commande;
	
	@ManyToMany
	(mappedBy = "articles")
	private List<Panier> panier;
	
	@Column (name="nom")
	private String nom;
	
	@Column (name="definition")
	private String definition;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}
	public Article(){
		
	}
}
