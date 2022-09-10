package br.com.mbs.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.mbs.modelos.Pessoa;


@RestController
public class FolhaPagamentoControllerAPI {

	HashMap<Integer,Pessoa> mapaPessoa = new HashMap<>();
	
	public FolhaPagamentoControllerAPI() {
		Pessoa p1 = new Pessoa();
		p1.setId("1");
		p1.setSalario(200f);
		
		Pessoa p2 = new Pessoa();
		p2.setId("2");
		p2.setSalario(300f);
		
		mapaPessoa.put(1, p1);
		mapaPessoa.put(2, p2);
		
	}
	
	@RequestMapping(value = "/folha-pagamento/pessoa/salario/{id}", 
			method = RequestMethod.GET)	 
	public ResponseEntity<Float> buscarSalarioPessoa(@PathVariable Integer id){		 
		Pessoa pessoa = mapaPessoa.getOrDefault(id, new Pessoa());
		Float salario = pessoa.getSalario();
		return ResponseEntity.ok(salario);
	}
	
	@RequestMapping(value = "/folha-pagamento/pessoa/salario/", 
			method = RequestMethod.GET)	 
	public ResponseEntity<List<Float>> buscarSalariosPessoa(){		 
		 
		List<Float> listaSalario = mapaPessoa
								  .values()
								  .stream()
								  .map(pessoa -> pessoa.getSalario())
								  .toList();
		
		return ResponseEntity.ok(listaSalario);
	}
	
	@RequestMapping(value = "/folha-pagamento/pessoa/salario/", 
			method = RequestMethod.POST)	 
	public ResponseEntity<Integer>
			salvarPessoa(@RequestBody Pessoa pessoa){		 
		 
		mapaPessoa.put(Integer.parseInt(pessoa.getId()), pessoa);
		
		return ResponseEntity.ok(Integer.parseInt(pessoa.getId()));
	}
}
