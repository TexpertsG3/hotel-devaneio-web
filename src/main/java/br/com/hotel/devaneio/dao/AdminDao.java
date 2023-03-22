package br.com.hotel.devaneio.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import br.com.hotel.devaneio.modelo.Admin;

public class AdminDao {
	
		public AdminDao () {}
	 
		private EntityManager entityManager;   //Com isso vamos receber uma conexão e não criar em cada um
		
		
		public AdminDao(EntityManager entityManager) {
			this.entityManager = entityManager;
		}
		
		public void insere(Admin admin) {
			this.entityManager.persist(admin);
		}
		
		public Optional<Admin> bucaPor(int id) {     //O Optional é usado para não ter o problema de nulo
			return Optional.ofNullable(this.entityManager.find(Admin.class, id));   //Com o nullable a gente se previne do Null Pointer Exception
		}
			
		public List<Admin> lista(){
			return this.entityManager.createQuery("select a from Admin a", Admin.class).getResultList();
		}
		
		public List<Admin> listaPor(String nome){
			String jpql = "select a from Admin a where a.nome = :nome_admin";
			return this.entityManager.createQuery(jpql, Admin.class)
					.setParameter("nome", nome)
					.getResultList();
		}
		
		public void delete (Admin admin) {
			//Deixar a moto managed
			admin = this.entityManager.merge(admin);
			this.entityManager.remove(admin);
		}
		
		public void atualiza(Admin admin) {
			this.entityManager.merge(admin);
		}

}

	

