package fr.cinepantin.modele;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.cinepantin.modele.Enum.EnumStock;

@Entity
@Table (name="stock")
public class Stock {
	
	@Id
	@Column (name="idStock")
	private String id;
	@OneToMany
	(mappedBy="etatStock")
	private List<Article> articles;
	
	@Column (name="etatStock")
	private String etatStock;
	

}
