package vc.com.cartorios.controller;

import static java.nio.charset.StandardCharsets.ISO_8859_1;
import static java.nio.charset.StandardCharsets.UTF_8;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping(value="/pesquisa", method=RequestMethod.GET)
	public ModelAndView pesquisarCartorioPagina(){
		return new ModelAndView("pesquisar-cartorio");
		
	}
	
	@RequestMapping(value="/pesquisar",method=RequestMethod.GET)
	public ModelAndView pesquisarCartorio(@RequestParam String paramPesquisa, 
			String valor, Model model){
		
		byte[]bytesParamPesquisa=paramPesquisa.getBytes(ISO_8859_1);
		byte[]bytesValorPesquisa=valor.getBytes(ISO_8859_1);
		
		String parametroEmUTF8 = new String(bytesParamPesquisa, UTF_8);
		String valorEmUTF8 = new String(bytesValorPesquisa,UTF_8);
		
		List<Cartorio> cartorios = new ArrayList<>();
		
		if(parametroEmUTF8.equalsIgnoreCase("Cartórios"))			
			cartorios = cartorioService.pesquisarTodosCartorios();
		else
			cartorios = cartorioService.pesquisarCartorio(parametroEmUTF8, valorEmUTF8);
		
		model.addAttribute("listaCartorios",cartorios);
		
		ModelAndView modelAndView = new ModelAndView("pesquisar-cartorio");
		return modelAndView;
	}
	
	
}
