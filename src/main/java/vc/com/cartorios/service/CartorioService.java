package vc.com.cartorios.service;

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
	
}
