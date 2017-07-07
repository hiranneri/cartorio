package vc.com.cartorios.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class InicioController {
	
	public ModelAndView start(){
		return new ModelAndView("index");
	}
	
	@RequestMapping("/index")
	public ModelAndView indexPagina(){
		return new ModelAndView("index");
	}
}
