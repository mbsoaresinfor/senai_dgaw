package com.mbs.enderecomvc.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mbs.enderecomvc.entidades.Endereco;
import com.mbs.enderecomvc.servico.EnderecoServico;


@Controller
public class EnderecoControllerMVC {

	EnderecoServico enderecoServico
	= new EnderecoServico();
	
	
	@GetMapping("/inicio_cadastrar")
	public String inicio( Model model) {
		model.addAttribute("endereco", 
				new Endereco());
		return "cadastrar";
	}
	
	@PostMapping(path="/cadastrar")
	public String salvar(
			@ModelAttribute 
			Endereco endereco,
			Model model) {
		
			String resultado = enderecoServico
					.salvar(endereco);
			
			if(resultado.isEmpty()) {
				model.addAttribute("lista_endereco",
						enderecoServico.listar()); // adiciona na request para a view pegar.
				return "resultado";
			}else {
				model.addAttribute("erro",resultado);
				return "cadastrar";
			}
	}
	
	@GetMapping("/deletar")
	public String deletar(@RequestParam String id,
			Model model) {
		System.out.println("Deletar: ID = " + id);
		enderecoServico.remover(Integer.parseInt(id));
		model.addAttribute("lista_endereco",
				enderecoServico.listar()); // adiciona na request para a view pegar.
		return "resultado";
	}
	
	@GetMapping("/inicio_buscar")
	public String inicioBuscar( Model model) {
		model.addAttribute("endereco", 
				new Endereco());
		return "buscar";
	}
	
	@GetMapping(path="/buscar")
	public String buscar(
			@ModelAttribute 
			Endereco endereco,
			Model model) {
		System.out.println("Buscar");
		StringBuilder resultado = new StringBuilder();
		
		for (Endereco end : listaEndereco) {
			if(end.getCodigo()
					.equals(endereco.getCodigo())) {
				resultado
				.append("cod:")
				.append(end.getCodigo())
				.append("rua: ")
				.append(end.getRua())
				.append("-----");				
			}else if(end.getCep()
					.equals(endereco.getCep())) {
				resultado
				.append("cep:")
				.append(end.getCep())
				.append("rua: ")
				.append(end.getRua())
				.append("-----");
			}
		}
		if(resultado.isEmpty()) {
			resultado.append("NÃO FOI POSSIVEL "
					+ "LOCALIZAR NENHUM ENDERECO");
		}
		model.addAttribute("resultado", 
				resultado.toString());
		return "buscar";
	}
	
	
	// CONTINUAR AS IMPLEMENTACOES
}
