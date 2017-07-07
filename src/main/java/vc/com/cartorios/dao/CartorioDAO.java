package vc.com.cartorios.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import vc.com.cartorios.model.Cartorio;

@Repository
public class CartorioDAO  {
	

	public EntityManager getEM(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("desafiocartorios");
		return factory.createEntityManager();
	}
	//Cartorio com id nulo,irá cadastrar, caso contrário altera
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
	
		public Cartorio buscarPeloId(Long id){
			EntityManager em = getEM();
			Cartorio cartorio;
			try{
				cartorio = em.find(Cartorio.class, id);
			}finally{
				em.close();
			}
			
			return cartorio;
		}
		@SuppressWarnings("unchecked")
		public List<Cartorio> listarCartorios(){
			EntityManager em = getEM();
			List<Cartorio> cartorios = new ArrayList<>();
			Query query = em.createQuery("from Cartorio");
			cartorios =query.getResultList();
			return cartorios;
		}

		public void excluirCartorio(Long id){
			EntityManager em = getEM();
			try{
				Cartorio cartorio = em.find(Cartorio.class, id);
				em.remove(cartorio);
				em.getTransaction().commit();
			}finally{
				em.close();
			}
		}
		
}
