package br.com.mbs.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.mbs.modelos.Pessoa;


@Controller
public class PessoaControllerMVC {

	// exemplo de mvc
	  
	private List<Pessoa> listaPessoa = new ArrayList<Pessoa>();
   
   @GetMapping("/tela-cadastrar-pessoa")
   public String telaCadastroPessoa(Model model) {
       model.addAttribute("pessoa", new Pessoa());
       return "tela-cadastrar-pessoa";
   }
   
   @PostMapping("/processa-cadastrar-pessoa")
   public String processaCadastrarPessoa(@ModelAttribute("pessoa") Pessoa pessoa, Model model) {
	   listaPessoa.add(pessoa);
	   model.addAttribute("listaPessoa", listaPessoa);      
      return "listar-pessoa";
   }
   
   @GetMapping("/iniciar-buscar-pessoa-por-id")
   public String iniciarBuscarPessoaPorID(Model model) {
      return "buscar-pessoa-por-id";
   }
   
   @PostMapping("/buscar-pessoa-por-id")
   public String buscarPessoaPorID(@RequestParam("id") String id,
		   									Model model) {
       
	  Optional<Pessoa> optPessoa = listaPessoa
		   	.stream()
		   	.filter(pessoa -> pessoa.getId().equals(id))
		   	.findFirst();
	   
	   if(optPessoa.isPresent()) {
		   Pessoa pessoa = optPessoa.get();
		   model.addAttribute("pessoa", pessoa);
		   return "mostra-pessoa-por-id";
	   }else {	   
		   return "mostra-pessoa-nao-encontrada";
	   }
   }
   
   // 
   
   @GetMapping("/iniciar-deletar-pessoa-por-id")
   public String iniciarDeletarPessoaPorID(Model model) {
      return "deletar-pessoa-por-id";
   }
   
   @PostMapping("/deletar-pessoa-por-id")
   public String deletarPessoaPorID(@RequestParam("id") String id,
		   									Model model) {
       
	  Boolean foiRemovido = listaPessoa
			  .removeIf(pessoa -> pessoa.getId().equals(id));
	   
	   if(foiRemovido) {
		   model.addAttribute("listaPessoa", listaPessoa);
		   return "listar-pessoa";
	   }else {	   
		   return "mostra-pessoa-nao-encontrada";
	   }
   }
}
