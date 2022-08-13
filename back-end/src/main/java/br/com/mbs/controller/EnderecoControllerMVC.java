package br.com.mbs.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import br.com.mbs.modelos.Endereco;
import br.com.mbs.modelos.Pessoa;
import br.com.mbs.servicos.EnderecoServico;


@Controller
public class EnderecoControllerMVC {

	EnderecoServico enderecoServico = new EnderecoServico();
	
	
	@GetMapping("/iniciar-cadastrar-endereco")
	   public String iniciarCadastrarEndereco(Model model) {
		model.addAttribute("endereco", new Endereco());  
		return "tela-cadastrar-endereco";
	}
	
	
   @PostMapping("/processa-cadastrar-endereco")
   public String processaCadastrarEndereco(@ModelAttribute("endereco") Endereco endereco,
		   							Model model) {

	 boolean sucesso = enderecoServico.salvarEndereco(endereco);
	 if(sucesso) {
		  return "sucesso";	 
	 }else{
		  return "error";		 
	 }
	 	
	         
      
   }
	
}
