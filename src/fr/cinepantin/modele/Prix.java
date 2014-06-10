package fr.cinepantin.modele;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="prix")
public class Prix {
	
	@Id
	@Column (name="idPrix", nullable=false)
	private String id;
	
	@OneToMany
	(mappedBy="prix")
	private List<Article> articles;
	
	@Column(name="prixHT")
	private double prixHT;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getPrixHT() {
		return prixHT;
	}

	public void setPrixHT(double prixHT) {
		this.prixHT = prixHT;
	}
	public Prix (){
		
	}
	public Prix(String id, double prixHT) {
		super();
		this.id = id;
		this.prixHT = prixHT;
	}
}
