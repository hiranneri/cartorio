package vc.com.cartorios.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import vc.com.cartorios.model.Funcionario;

@Repository
public class LoginDAO {
	
	public  EntityManager getEM(){
		EntityManagerFactory factory =Persistence.createEntityManagerFactory("desafiocartorios"); 
		return factory.createEntityManager();
	}

	@Transactional
	public Funcionario validarFuncionario(Funcionario funcionario){
		EntityManager em = getEM();
		Funcionario funcionarioLocalizado;
		try{
			Query query = em.createQuery("from Funcionario where nm_nome=:nome");
			query.setParameter("nome", funcionario.getNome());
			funcionarioLocalizado = Funcionario.castList
					(Funcionario.class,query.getResultList()).get(0);
			return funcionarioLocalizado;
		}catch(Exception e){
			return null;
			
		}
		finally{
			em.close();
		}
	}
}
