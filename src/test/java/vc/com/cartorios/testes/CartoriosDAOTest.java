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
	Cartorio cartorioSaoVicente;
	Endereco enderecoCartorioSaoVicente;
	CartorioDAO cartorioDAO;
	Cartorio cartorioLocalizado;
	List<Cartorio>cartorios;
	@Before
	public void setUp() throws Exception {
		cartorioSaoVicente = new Cartorio();
		
		cartorioSaoVicente.setNome("Cartório de Santos");
		
		enderecoCartorioSaoVicente = new Endereco();
		enderecoCartorioSaoVicente.setRua("Avenida Mal.");
		enderecoCartorioSaoVicente.setNumero(100);
		enderecoCartorioSaoVicente.setBairro("Sab");
		enderecoCartorioSaoVicente.setCidade("São Paulo");
		enderecoCartorioSaoVicente.setEstado("São Paulo");
		cartorioSaoVicente.setEndereco(enderecoCartorioSaoVicente);
		
		this.cartorioDAO = new CartorioDAO();
		
		cartorioLocalizado = new Cartorio();
		this.cartorios = new ArrayList<>();
	}
	@Test
	public void testSalvar() {
		 
		try{
			Long id = cartorioDAO.salvar(cartorioSaoVicente).getId();
			assertNotEquals(null, id);
			
			cartorioLocalizado = cartorioDAO.buscarPeloId(id);
			assertEquals("Cartório de Santos", cartorioLocalizado.getNome());
			assertEquals("Avenida Mal.", cartorioLocalizado.getEndereco().getRua());
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	@Test
	public void testPesquisarTodosCartorios(){
		cartorios = cartorioDAO.listarCartorios();
		assertNotEquals(null, cartorios);
		assertTrue(cartorios.size()>0);
		Cartorio c = cartorios.get(0);
		assertEquals("Cartório de São Vicente", c.getNome());
		
	}
	@Test
	public void testPesquisarPeloID(){
		Cartorio c = cartorioDAO.buscarPeloId(2L);
		assertNotEquals(null, c);
		assertEquals("Cartório de Santos", c.getNome());
	}
	@Test
	public void testPesquisarPeloNome(){
		List<Cartorio>cartorios = cartorioDAO.buscarPeloNome("Cartório de São Vicente");
		assertNotEquals(null,cartorios);
		assertTrue(cartorios.size()>0);
		Cartorio c = cartorios.get(0);
		assertEquals("Cartório de São Vicente", c.getNome());
	}
	
	
}
