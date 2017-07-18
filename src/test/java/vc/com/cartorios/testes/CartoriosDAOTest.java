package vc.com.cartorios.testes;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import vc.com.cartorios.dao.CartorioDAO;
import vc.com.cartorios.model.Cartorio;
import vc.com.cartorios.model.Endereco;

public class CartoriosDAOTest {
	Cartorio cartorioFerrazVasconcelos;
	Endereco enderecoFerraz;
	CartorioDAO cartorioDAO;
	Cartorio cartorioLocalizado;
	List<Cartorio>cartorios;
	
	@Before
	public void setUp() throws Exception {
		cartorioFerrazVasconcelos = new Cartorio();
		
		cartorioFerrazVasconcelos.setNome("Cartório de Ferraz de Vasconcelos");
		
		enderecoFerraz = new Endereco();
		enderecoFerraz.setRua("Avenida Mal.");
		enderecoFerraz.setNumero(10);
		enderecoFerraz.setBairro("Angélica");
		enderecoFerraz.setCidade("São Paulo");
		enderecoFerraz.setEstado("São Paulo");
		cartorioFerrazVasconcelos.setEndereco(enderecoFerraz);
		
		this.cartorioDAO = new CartorioDAO();
		
		cartorioLocalizado = new Cartorio();
		this.cartorios = new ArrayList<>();
	}
	@Test
	public void testSalvar() {
		 
		try{
			Long id = cartorioDAO.salvar(cartorioFerrazVasconcelos).getId();
			assertNotEquals(null, id);
			
			cartorioLocalizado = cartorioDAO.pesquisarPorID(id);
			assertEquals("Cartório de Santos", cartorioLocalizado.getNome());
			assertEquals("Avenida Mal.", cartorioLocalizado.getEndereco().getRua());
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	@Test
	public void testEditar(){
		try{
			cartorioFerrazVasconcelos.setId(2L);
			cartorioFerrazVasconcelos.setNome("Cartório Editado");
			Cartorio c = cartorioDAO.salvar(cartorioFerrazVasconcelos);
			assertNotEquals(null,c);
			assertEquals("Cartório Editado",c.getNome());
			assertEquals(Long.valueOf(2L), c.getId());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@Test
	public void testPesquisarPeloNome(){
		Cartorio cartorio = cartorioDAO.pesquisarPorNome("Cartório de Ferraz de Vasconcelos");
		assertNotEquals(null,cartorio);
		assertEquals("Cartório de São Vicente", cartorio.getNome());
	}
	
}
