package com.mbs.vendasServices.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloControllerMVC {

	// exemplo de mvc


   @GetMapping("/hello")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="MVC") String name, Model model) {
		System.out.println("o valor da variavel name é: " + name);
	   model.addAttribute("name", name);
		return "hello";
	}
   
}