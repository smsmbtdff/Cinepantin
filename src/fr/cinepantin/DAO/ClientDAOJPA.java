package fr.cinepantin.DAO;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.UserTransaction;

import fr.cinepantin.modele.Article;
import fr.cinepantin.modele.Client;

public class ClientDAOJPA implements ClientDAO {
	
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
		// création d'un client en base.
		try{
		ut.begin();
		em.persist(c);
		ut.commit();
		}catch (Exception e) {
			e.printStackTrace();
			throw new DAOExceptions("pb insertion de dvd:" + e.getMessage(), e);
		}
	}

	@Override
	public void delete(Client c) throws DAOExceptions {
		// suppression du client par l'ID.
			String query = "delete from Client c where c.id like ?1";
			TypedQuery<Client> q = em.createQuery(query,Client.class);
			q.setParameter(1, c.getId());
		
	}

	@Override
	public List<Article> findByNom(Article a) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
