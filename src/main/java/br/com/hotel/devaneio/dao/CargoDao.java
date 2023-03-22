package br.com.hotel.devaneio.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.hotel.devaneio.modelo.Cargo;
import br.com.hotel.devaneio.util.JPAFactory;

public class CargoDao {

		private EntityManager entityManager;
		
		public CargoDao() {}
	
		public CargoDao(EntityManager entityManager) {
			this.entityManager = entityManager;
		}
	
		public void insere(Cargo cargo) throws SQLException {
			
			EntityManager em = JPAFactory.getEntityManager();
			em.getTransaction().begin();
			em.persist(cargo);
			em.getTransaction().commit();
			em.close();
		}

		public List<Cargo> lista() {
			EntityManager em = JPAFactory.getEntityManager();
		    return em.createQuery("select c from Cargo c", Cargo.class).getResultList();
		}
		

		public void delete(Integer id) {
		    EntityManager em = JPAFactory.getEntityManager();
		    em.getTransaction().begin();
		    Cargo cargo = em.find(Cargo.class, id);
		    em.remove(cargo);
		    em.getTransaction().commit();
		    em.close();
		}

		public void atualiza(Cargo cargo) {
			this.entityManager.merge(cargo);
		}

		
	}
