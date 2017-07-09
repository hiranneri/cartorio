package vc.com.cartorios.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import vc.com.cartorios.dao.CartorioDAO;
import vc.com.cartorios.model.Cartorio;

@Service
public class CartorioService {
	@Inject
	private CartorioDAO cartorioDAO;
	
	public boolean cadastrarCartorio(Cartorio cartorio){
		try{
		cartorioDAO.salvar(cartorio);
		return true;
		}catch (Exception e) {
			return false;
		}
	}
	public List<Cartorio> pesquisarCartorio(String parametro,String valor){
		List<Cartorio> cartorios = new ArrayList<>();
		if(parametro.equalsIgnoreCase("id")){
			cartorios.add(cartorioDAO.buscarPeloId(Long.parseLong(valor)));
		}else if(parametro.equalsIgnoreCase("nome")) {
			cartorios=cartorioDAO.buscarPeloNome(valor);
		}else{
			return null;
		}
		return cartorios;
		
	}
	public List<Cartorio> pesquisarTodosCartorios(){
		return cartorioDAO.listarCartorios();
		
	}
}
