package vc.com.cartorios.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vc.com.cartorios.model.Cartorio;
import vc.com.cartorios.service.CartorioService;
import vc.com.cartorios.util.CartorioDTO;

@Controller
@RequestMapping("/cartorio")
public class CartorioController {
	
	@Autowired
	private CartorioService cartorioService;
	
	@RequestMapping(value="/cadastrar", method=RequestMethod.GET)
	public ModelAndView cadastrarCartorioPagina(Cartorio cartorio){
		ModelAndView modelAndView = new ModelAndView("cadastrar-cartorio");
		modelAndView.addObject("cartorio",cartorio);
		return modelAndView;
	}
	
	@RequestMapping(value="/cadastrar",method=RequestMethod.POST)
	public ModelAndView cadastrarCartorio(@ModelAttribute @Valid Cartorio cartorio, BindingResult result){
		ModelAndView modelAndView = new ModelAndView("mensagem");
		if(result.hasErrors()){
			return cadastrarCartorioPagina(cartorio);
		}
		boolean response = cartorioService.cadastrarCartorio(cartorio);
		modelAndView.addObject("message",mensagem(response));
		return modelAndView;
	}
	
	@RequestMapping(value="/pesquisa", method=RequestMethod.GET)
	public ModelAndView pesquisarCartorioPagina(){
		return new ModelAndView("pesquisar-cartorio");
		
	}
	
	@RequestMapping(value="/pesquisar",method=RequestMethod.GET)
	public ModelAndView pesquisarCartorio(@ModelAttribute CartorioDTO parametrosCartorio,
			Model model){
		ModelAndView modelAndView = new ModelAndView("pesquisar-cartorio");
		Cartorio cartorio = cartorioService.pesquisarCartorio(parametrosCartorio);
		model.addAttribute("cartorio",cartorio);
		return modelAndView;
	}
	
	@RequestMapping("/editar")
	public ModelAndView editarCartorioPagina(@RequestParam String id,Model model){
		Cartorio cartorioLocalizado = cartorioService.pesquisarCartorio(id);
		model.addAttribute("cartorio", cartorioLocalizado);
		return new ModelAndView("editar-cartorio");
	}
	
	@RequestMapping("/excluir")
	public ModelAndView excluirCartorio(@RequestParam String id, Model model){
		ModelAndView modelAndView = new ModelAndView("mensagem");
		boolean response = cartorioService.excluirCartorio(id);
		String message = "";
		if(response)
			message = "Cartório excluído com sucesso";
		else
			message = "Não foi possível excluir o cartório. Tente novamente";
		modelAndView.addObject("message",message);
		return modelAndView;
	}
	private String mensagem(boolean response){
		String message = "";
		if(response)
			message = "Cartório salvo com sucesso";
		else
			message = "Não foi possível salvar o cartório. Tente novamente";
		return message;
	}
}
