package vc.com.cartorios.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vc.com.cartorios.model.Funcionario;
import vc.com.cartorios.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService login;
	@Autowired
	private HttpSession session;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView start(@ModelAttribute Funcionario funcionario){
		
		return new ModelAndView("login");
		
	}
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	public ModelAndView validarUsuario( @ModelAttribute Funcionario funcionario){
		if(login.validarFuncionario(funcionario)){
			session.setAttribute("funcionarioLogado", funcionario);
			return new ModelAndView("index");
			
			
		}
		return new ModelAndView("erro-login");
	}
	@RequestMapping(value="/sair",method=RequestMethod.GET)
	public ModelAndView sair(Model model, Funcionario funcionario){
		session.invalidate();
		return new ModelAndView("login");
	}
}
