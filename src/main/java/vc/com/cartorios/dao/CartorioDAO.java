package vc.com.cartorios.dao;

import java.util.List;

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
		Cartorio cartorio=null;
		try{
			//select id,nm_cartorio from tb_cartorios order by id desc limit 1;
			Query query = em.createQuery("from Cartorio where nome like :nome");
			query.setParameter("nome", "%"+nome+"%");
			List<Cartorio> lista = Cartorio.castList(Cartorio.class, query.getResultList());
			cartorio = lista.get(lista.size()-1);
			return cartorio;
		}catch(Exception e){
			return null;
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
			}catch(Exception e){
				return;
			}finally{
				em.close();
			}
		}

	public List<Cartorio> findAll() {
		// TODO Auto-generated method stub
		EntityManager em = getEM();
		try{
			Query query = em.createQuery("from Cartorio");
			List<Cartorio> cartorios = Cartorio.castList
					(Cartorio.class, query.getResultList());
			return cartorios;
		}finally{
			em.close();
		}
	}
	public List<Cartorio> salvarCartorios(List<Cartorio>cartorios){
		
		EntityManager em = getEM();
		try{
			em.getTransaction().begin();
			for(Cartorio cartorio:cartorios){
				em.persist(cartorio);
			}
			em.getTransaction().commit();
		}finally{
			
			em.close();
		}
		return cartorios;
	}
	
}
