package fr.cinepantin.DAO;

import java.util.List;

import fr.cinepantin.modele.Article;
import fr.cinepantin.modele.Client;

public interface ClientDAO {
	
	void update (Client c) throws DAOExceptions;
	void create (Client c) throws DAOExceptions;
	void delete (Client c) throws DAOExceptions;
	List<Article> findByNom (Article a);
}
