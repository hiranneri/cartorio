package vc.com.cartorios.testes;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import vc.com.cartorios.dao.CartorioDAO;
import vc.com.cartorios.model.Cartorio;
import vc.com.cartorios.model.Endereco;

public class CartoriosDAOTest {
	Cartorio cartorioSaoVicente;
	Endereco enderecoCartorioSaoVicente;
	CartorioDAO cartorioDAO;
	Cartorio cartorioLocalizado;
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
	
}
