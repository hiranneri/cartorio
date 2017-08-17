package vc.com.cartorios.testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import vc.com.cartorios.dao.LoginDAO;
import vc.com.cartorios.model.Funcionario;

public class LoginDAOTest {
	private Funcionario funcionarioCadastrado;
	private LoginDAO loginDAO;
	private Funcionario f;
	@Before
	public void setUp() throws Exception {
		funcionarioCadastrado = new Funcionario();
		funcionarioCadastrado.setNome("Rafael");
		funcionarioCadastrado.setSenha("123R");
		
		loginDAO = new LoginDAO();
		f = new Funcionario();
		
		
	}
	@Test
	public void testValidarFuncionarioCadastrado() {
		f = loginDAO.validarFuncionario(this.funcionarioCadastrado);
		assertEquals(funcionarioCadastrado.getNome(),f.getNome());
		assertEquals(funcionarioCadastrado.getSenha(),f.getSenha());
		
		
	}
	
	@Test
	public void testValidarFuncionarioSemCadastro(){
		Funcionario funcionarioSemCadastro = new Funcionario();
		funcionarioSemCadastro.setNome("Joaquim");
		funcionarioSemCadastro.setSenha("456J");
		
		f = loginDAO.validarFuncionario(funcionarioSemCadastro);
		assertNull(f);
	}

}
