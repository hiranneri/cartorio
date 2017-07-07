package vc.com.cartorios.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vc.com.cartorios.model.Cartorio;
import vc.com.cartorios.service.CartorioService;

@Controller
@RequestMapping("/cartorio")
public class CartorioController {
	
	@Autowired
	private CartorioService cartorioService;
	
	@RequestMapping(value="/cadastrar", method=RequestMethod.GET)
	public ModelAndView cadastrarCartorioPagina(){
		ModelAndView modelAndView = new ModelAndView("cadastrar-cartorio");
		modelAndView.addObject("cartorio",new Cartorio());
		return modelAndView;
	}
	
	@RequestMapping(value="/cadastrar",method=RequestMethod.POST)
	public ModelAndView cadastrarCartorio(@ModelAttribute Cartorio cartorio){
		ModelAndView modelAndView = new ModelAndView("mensagem");
		boolean response = cartorioService.cadastrarCartorio(cartorio);
		String message = "";
		if(response)
			message = "Cartório salvo com sucesso";
		else
			message = "Não foi possível salvar o cartório. Tente novamente";
		modelAndView.addObject("message",message);
		return modelAndView;
	}
}
