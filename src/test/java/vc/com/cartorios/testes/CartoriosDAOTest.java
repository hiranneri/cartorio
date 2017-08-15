package vc.com.cartorios.testes;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
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
		
		cartorioFerrazVasconcelos.setNome("Cartório de Cubatão");
		
		enderecoFerraz = new Endereco();
		enderecoFerraz.setRua("Avenida 9 de Abril");
		enderecoFerraz.setNumero(102);
		enderecoFerraz.setBairro("Angélica");
		enderecoFerraz.setCidade("Cubatão");
		enderecoFerraz.setEstado("São Paulo");
		cartorioFerrazVasconcelos.setEndereco(enderecoFerraz);
		
		this.cartorioDAO = new CartorioDAO();
		
		cartorioLocalizado = new Cartorio();
		this.cartorios = new ArrayList<>();
	}
	@Test
	@Ignore
	public void testSalvar() {
		 
		try{
			Long id = cartorioDAO.salvar(cartorioFerrazVasconcelos).getId();
			assertNotEquals(null, id);
			
			cartorioLocalizado = cartorioDAO.pesquisarPorID(id);
			assertEquals("Cartório de Cubatão", cartorioLocalizado.getNome());
			assertEquals("Avenida 9 de Abril", cartorioLocalizado.getEndereco().getRua());
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	@Test
	@Ignore
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
		Cartorio cartorio = cartorioDAO.pesquisarPorNome("Praia Grande");
		assertNotEquals(null,cartorio);
		assertEquals("9º Cartório de Praia grande", cartorio.getNome());
		assertEquals(Long.valueOf(22L),cartorio.getId());
	}
	@Test
	@Ignore
	public void testFindAll() {
		List<Cartorio> cartorios = cartorioDAO.findAll();
		assertNotEquals(null, cartorios);
		assertTrue(cartorios.size()>0);
	}
	/*Para salvar um cartório (via REST), forneça uma lista com um único objeto 
	 * do tipo Cartório
	 * Ou deseja salvar uma lista de cartórios, forneça uma lista com os mesmos.
	 */
	@Test
	@Ignore
	public void testSalvarCartorios(){
		List<Cartorio>listaDeUmCartorio = new ArrayList<>();
		listaDeUmCartorio.add(criarUmCartorio());
		listaDeUmCartorio = cartorioDAO.salvarCartorios(listaDeUmCartorio);
		assertNotEquals(null, listaDeUmCartorio.get(0).getId());
		
		List<Cartorio>listaDeVariosCartorios = new ArrayList<>();
		listaDeVariosCartorios.addAll(criarVariosCartorios());
		listaDeVariosCartorios = cartorioDAO.salvarCartorios(listaDeVariosCartorios);
		for(int i=0;i<listaDeUmCartorio.size();i++)
			assertNotEquals(null, listaDeVariosCartorios.get(i).getId());
	}
	@Test
	@Ignore
	public void testExcluir(){
		Long id = 9L;
		cartorioDAO.excluir(id);
		Cartorio cartorioExcluido = cartorioDAO.pesquisarPorID(id);
		assertEquals(null, cartorioExcluido);
	}
	
	private Cartorio criarUmCartorio(){
		Cartorio cartorioMooca = new Cartorio();
		cartorioMooca.setNome("23º Cartório da Mooca");
		Endereco enderecoCartorioMooca = new Endereco();
		enderecoCartorioMooca.setRua("Rua Diamantino");
		enderecoCartorioMooca.setNumero(1);
		enderecoCartorioMooca.setBairro("Mooca");
		enderecoCartorioMooca.setCidade("São Paulo");
		enderecoCartorioMooca.setEstado("São Paulo");
		cartorioMooca.setEndereco(enderecoCartorioMooca);
		return cartorioMooca;
	}
	
	private List<Cartorio> criarVariosCartorios(){
		List<Cartorio> cartorios = new ArrayList<>();
		
		Cartorio cartorioJabaquara = new Cartorio();
		cartorioJabaquara.setNome("23º Cartório do Jabaquara");
		Endereco enderecoCartorioJabaquara = new Endereco();
		enderecoCartorioJabaquara.setRua("Rua Diamantino");
		enderecoCartorioJabaquara.setNumero(1);
		enderecoCartorioJabaquara.setBairro("Jabaraqua");
		enderecoCartorioJabaquara.setCidade("São Paulo");
		enderecoCartorioJabaquara.setEstado("São Paulo");
		cartorioJabaquara.setEndereco(enderecoCartorioJabaquara);
		
		Cartorio cartorioSe = new Cartorio();
		cartorioSe.setNome("20º Cartório da Sé");
		Endereco enderecoCartorioSe = new Endereco();
		enderecoCartorioSe.setRua("Rua Diamantino");
		enderecoCartorioSe.setNumero(1);
		enderecoCartorioSe.setBairro("Sé");
		enderecoCartorioSe.setCidade("São Paulo");
		enderecoCartorioSe.setEstado("São Paulo");
		cartorioSe.setEndereco(enderecoCartorioSe);
		
		Cartorio cartorioMooca = new Cartorio();
		cartorioMooca.setNome("23º Cartório da Mooca");
		Endereco enderecoCartorioMooca = new Endereco();
		enderecoCartorioMooca.setRua("Rua Diamantino");
		enderecoCartorioMooca.setNumero(1);
		enderecoCartorioMooca.setBairro("Mooca");
		enderecoCartorioMooca.setCidade("São Paulo");
		enderecoCartorioMooca.setEstado("São Paulo");
		cartorioMooca.setEndereco(enderecoCartorioMooca);
		
		cartorios.add(cartorioSe);
		cartorios.add(cartorioJabaquara);
		cartorios.add(cartorioMooca);
		
		return cartorios;
	}
}
