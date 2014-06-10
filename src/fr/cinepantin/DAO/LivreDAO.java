package fr.cinepantin.DAO;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.UserTransaction;

import fr.cinepantin.modele.Article;
import fr.cinepantin.modele.Client;

public class LivreDAO implements ClientDAO{
	// obtention d'un manager d'entités sur un contexte de persistance
		// de durée transactionnelle.
		@PersistenceContext
		private EntityManager em;
		@Resource
		// utilisation du gestionnaire de transaction du serveur d'application
		// (API JTA).
		private UserTransaction ut;

	@Override
	public void update(Client c) throws DAOExceptions {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(Client c) throws DAOExceptions {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Client c) throws DAOExceptions {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Article> findByNom(Article nom) {
		// TODO Auto-generated method stub
		String query = "select l from Livre l where l.prop.nom like ?1";
		TypedQuery<Article> q = em.createQuery(query,Article.class);
		q.setParameter(1, nom.getNom());
		return q.getResultList();
	}

}
