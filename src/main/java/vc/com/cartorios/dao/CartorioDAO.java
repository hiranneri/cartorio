package vc.com.cartorios.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import vc.com.cartorios.model.Cartorio;
@Repository
public class CartorioDAO  {
	
	
	public EntityManager getEM(){
		EntityManagerFactory factory =Persistence.createEntityManagerFactory("desafiocartorios"); 
		return factory.createEntityManager();
	}
	
	@Transactional
	public Cartorio salvar(Cartorio cartorio) throws Exception{
		
		EntityManager em = getEM();
		try{
			
			em.getTransaction().begin();
			if(cartorio.getId()==null){
				em.persist(cartorio);
			}else{
				if(!em.contains(cartorio)){
					if(em.find(Cartorio.class, cartorio.getId())==null){
						throw new Exception("Erro ao atualizar cartório");
					}
				}
					cartorio = em.merge(cartorio);
			}
			em.getTransaction().commit();
			
		}finally{
			em.close();
		}
			
		return cartorio;
		
	}
	@Transactional
	public Cartorio pesquisarPorID(Long id){
		EntityManager em = getEM();
		Cartorio cartorio;
		try{
			cartorio = em.find(Cartorio.class, id);
		}finally{
			em.close();
		}
		return cartorio;
	}
	@Transactional
	public Cartorio pesquisarPorNome(String nome){
		EntityManager em = getEM();
		try{
			Query query = em.createQuery("from Cartorio where nm_cartorio=:nome");
			query.setParameter("nome", nome);
			Cartorio cartorio = Cartorio.castList
					(Cartorio.class,query.getResultList()).get(0);
			return cartorio;
		}finally{
			em.close();
		}
		
	}
	
	public void excluir(Long id){
			EntityManager em = getEM();
			try{
				em.getTransaction().begin();
				em.remove(em.getReference(Cartorio.class, id));
				em.getTransaction().commit();
			}finally{
				em.close();
			}
		}
	 
	
}
