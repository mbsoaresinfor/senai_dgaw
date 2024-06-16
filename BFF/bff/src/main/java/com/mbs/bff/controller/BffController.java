package com.mbs.bff.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mbs.bff.comunicacao.ClienteService;
import com.mbs.bff.comunicacao.VendasService;
import com.mbs.bff.entidades.Venda;

@RestController
public class BffController {

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private VendasService vendasService;
	
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	@Value("${exchange}")
	private String exchange;
	
	// orquestramento de serviços
	@RequestMapping(value = "/v1/bff", method = RequestMethod.POST)	
	public ResponseEntity<Boolean> processarVenda(@RequestBody Venda venda){
		System.out.println("processando bff processarVenda");
		ResponseEntity<Boolean> respostaExisteCliente = 
				clienteService.existeCliente(venda.getCodCliente().longValue());
				
		if(respostaExisteCliente.getBody().equals(false)) {
			return ResponseEntity.ok(false);
		}
		
		vendasService.salvarVenda(venda);
		return ResponseEntity.ok(true);
	}
	
	@RequestMapping(value = "/v1/teste", method = RequestMethod.GET)	
		public void teste(){
		rabbitTemplate.convertAndSend("", exchange, "teste");
	}
}
