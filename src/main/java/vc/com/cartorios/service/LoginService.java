package vc.com.cartorios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vc.com.cartorios.dao.LoginDAO;
import vc.com.cartorios.model.Funcionario;

@Service
public class LoginService {
	@Autowired
	private LoginDAO loginDAO;
	
	public boolean validarFuncionario(Funcionario funcionario){
		Funcionario funcionarioLocalizado = loginDAO.validarFuncionario(funcionario);
		return funcionario.compararUsuario(funcionario, funcionarioLocalizado);
	}
}
