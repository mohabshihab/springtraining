package com.afit.training.springmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/ww", method = RequestMethod.GET)
	public String showHomeNoReRes() {
		return "index";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showHomeReqParam(@RequestParam(value="name", required=true) String name, ModelMap model) {
		model.addAttribute("firstname", name);
		return "index";
	}
	
	@RequestMapping(value = "/hello/{name}/result", method = RequestMethod.GET)
	public String showHomePathVar(@PathVariable(name="name") String name, ModelMap model) {
		model.addAttribute("firstname", name);
		return "index";
	}
	
	
	@RequestMapping(value = "/reqres", method = RequestMethod.GET)
	public String showHome(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		model.addAttribute("firstname", "Mohab");
		return "index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("firstname", "Mohab");
		return mv;
	}
	
	@RequestMapping(value = "/login_void", method = RequestMethod.GET)
	public void showLoginVoid(HttpServletRequest request, HttpServletResponse response) {
	}
	
	 
}
