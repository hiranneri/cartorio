package vc.com.cartorios.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class CriaTabela {
	private EntityManagerFactory factory;
	
	public CriaTabela(){
		this.factory = Persistence.createEntityManagerFactory("desafiocartorios",PersistenceProperties.get());
	}
	
	
	public EntityManager createEntityManager(){
		return this.factory.createEntityManager();
	}
	
	public void closeEntityManager(EntityManager em){
		em.close();
	}
	
	
	
}
