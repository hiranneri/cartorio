package vc.com.cartorios.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import vc.com.cartorios.dao.CartorioDAO;
import vc.com.cartorios.model.Cartorio;

@RestController
@RequestMapping("/cartorios")
public class CartorioResource {
	
	@Autowired
	private CartorioDAO cartorioDAO;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Cartorio> getCartorios(){
		return cartorioDAO.findAll();
	}
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Cartorio getCartorio(@PathVariable Long id){
		return cartorioDAO.pesquisarPorID(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE, 
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Cartorio> cadastrarCartorio(@RequestBody List<Cartorio> cartorios){
		try{
			if(cartorios.size()==1){
				//Objeto
				Cartorio cartorioCadastrado = cartorioDAO.salvar(cartorios.get(0));
				cartorios.remove(0);
				cartorios.add(cartorioCadastrado);
				 
				return cartorios;
			}
			if(cartorios.size()>1){
				//Lista
				return cartorioDAO.salvarCartorios(cartorios);
			}
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return null;
	}
	
	
	
}
