package fr.cinepantin.modele;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client implements Serializable {

	/**
	 * 
	 */
	/*private static final long serialVersionUID = 1L;*/

	
	@Column(name = "idClient", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private String id;
	
	@ManyToMany /*(fetch=FetchType.LAZY) */ // lien avec la table Adresse
	@JoinTable (
			name="lignes_adresses",
			joinColumns={@JoinColumn(name="Client_idClient", referencedColumnName = "idClient")},
			inverseJoinColumns={@JoinColumn(name="Adresses_idAdresse", referencedColumnName ="idAdresse")}
			)
	private List<Adresse> adresse;
	
	@OneToMany (mappedBy="client") //jointure table Commande
	private List<Commande> commande;
	
	@OneToMany (mappedBy="client") //jointure table Panier
	private List<Panier> panier;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	@Column(name="nom",nullable=false)
	private String nom;
	
	@Column(name="prenom",nullable=false)
	private String prenom;
	
	@Column(name = "AdresseMail",nullable=false)
	private String mail;
	
	@Column(name = "motDePasse",nullable=false)
	private String mdp;

	public Client(String nom, String prenom, String mail, String mdp) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.mdp = mdp;
	}
	public Client(){
	}
	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

}
