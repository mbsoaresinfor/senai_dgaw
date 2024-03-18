package com.mbs.vendasServices.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.mbs.vendasServices.entidades.Venda;
import com.mbs.vendasServices.servico.VendasServico;


@Controller
public class VendasControllerMVC {

	@Autowired
	private VendasServico vendasService;
	
	
	@GetMapping("/inicio_cadastrar")
	public String greeting( Model model) {
		model.addAttribute("venda", new Venda());
		return "cadastrar";
	}
	
	@PostMapping(path="/cadastrar")
	public String salvarVenda(@ModelAttribute Venda venda,Model model) {		
		System.out.println("processando salvarVenda " + venda);
		vendasService.salvarVendas(venda);
		return "resultado";
	}
	
	@GetMapping("/listar")
	public String listarVendas( Model model) {
		System.out.println("processando listarVendas " );
		model.addAttribute("lista_venda", vendasService.listarVendas());
		return "listar";
	}
	
	@GetMapping("/total_vendas")
	public String totalVendas( Model model) {			
		model.addAttribute("totalVenda",vendasService.totalVendas());
		return "total_vendas";
	}
	
}
