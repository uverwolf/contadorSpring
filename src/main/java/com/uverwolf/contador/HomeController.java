package com.uverwolf.contador;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("")
	public String Home(HttpServletRequest request, HttpSession sesion) {
		
		
		HttpSession session = request.getSession();
		if(session.isNew()) {
			session.setAttribute("contador", 0);
			int x = (int) session.getAttribute("contador");
			x++;
			session.setAttribute("contador",x);
		}else {
			int x = (int) session.getAttribute("contador");
			x++;
			session.setAttribute("contador",x);
		}
		
		
		return "index.jsp";
	}
	@RequestMapping("/contador")
	public String Contador(Model modelo, HttpServletRequest request, HttpSession sesion) {
		HttpSession session = request.getSession();
		if(session.isNew()) {
			session.setAttribute("contador", 0);
		}
		
		return "contador.jsp";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpServletRequest request, HttpSession sesion) {
		
		HttpSession session = request.getSession();
		session.setAttribute("contador", 0);
		return "redirect:/";
	}
}
