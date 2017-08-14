package vc.com.cartorios.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter{
	
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object controller)
		throws Exception{
		String uri = req.getRequestURI();
		if(uri.endsWith("/") || uri.contains("resources")){
				return true;
			}
		if(req.getSession().getAttribute("funcionarioLogado")!=null)
			return true;
		res.sendRedirect("/desafiocartorios/");
		return false;
	}

}
