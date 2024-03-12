package com.mbs.vendasServices.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	// estamos migrando para arquitetura 3 camadas.
	// por isso que está quebrado
	// sera ajustado na proxima aula.
	@Autowired
	private VendasServico vendasService;
	
	
	@GetMapping("/inicio_cadastrar")
	public String greeting( Model model) {
		model.addAttribute("venda", new Venda());
		return "cadastrar";
	}
	
	@PostMapping(path="/cadastrar")
	public String salvarVenda(@ModelAttribute Venda venda,Model model) {		
		System.out.println("processando venda de id " + id);
		vendasService.salvarVendas(venda);
		return "resultado";
	}
	
	@GetMapping("/listar")
	public String listarVendas( Model model) {
		model.addAttribute("lista_venda", mapaVendas.values());
		return "listar";
	}
	
	@GetMapping("/total_vendas")
	public String totalVendas( Model model) {
		List<Venda> lista = 
				new ArrayList<>(mapaVendas.values());
		Double totalVenda = 0d;
		for(Venda item: lista) {
			totalVenda= totalVenda 
					+ item.getTotalVenda();
		}		
		model.addAttribute("totalVenda", 
				totalVenda);
		return "total_vendas";
	}
	
}
