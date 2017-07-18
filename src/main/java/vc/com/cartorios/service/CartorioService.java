package vc.com.cartorios.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import vc.com.cartorios.dao.CartorioDAO;
import vc.com.cartorios.model.Cartorio;
import vc.com.cartorios.util.CartorioDTO;

@Service
public class CartorioService {
	@Inject
	private CartorioDAO cartorioDAO;
	
	public boolean cadastrarCartorio(Cartorio cartorio){
		try{
			cartorioDAO.salvar(cartorio);
		return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public Cartorio pesquisarCartorio(CartorioDTO cartorio){
		if(cartorio.getParametroPesquisa().equals("ID")){
			Cartorio cartorioLocalizado = cartorioDAO.pesquisarPorID(Long.parseLong(cartorio.getValor()));
			return cartorioLocalizado;
		}else if(cartorio.getParametroPesquisa().equals("Nome")){
			Cartorio cartorioLocalizado = cartorioDAO.pesquisarPorNome(cartorio.getValor());
			return cartorioLocalizado;
		}
		return null;
	}
	//Método para editar cartório
	public Cartorio pesquisarCartorio(String idCartorio){
		Cartorio cartorioLocalizado = cartorioDAO.pesquisarPorID(Long.parseLong(idCartorio));
		return cartorioLocalizado;
	}
	public boolean excluirCartorio(String id){
		try{
			cartorioDAO.excluir(Long.parseLong(id));
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
