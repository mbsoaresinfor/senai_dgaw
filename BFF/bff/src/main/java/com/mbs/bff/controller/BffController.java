package com.mbs.bff.controller;

import java.util.Date;

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
import com.mbs.bff.entidades.Cliente;

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
		System.out.println("-> orquestração: processando bff processarVenda");
		System.out.println("-> orquestração: verificando cliente");
		ResponseEntity<Boolean> respostaExisteCliente = 
				clienteService.existeCliente(venda.getCodCliente().longValue());
				
		if(respostaExisteCliente.getBody().equals(false)) {
			System.out.println("-> orquestração: cliente não existe");
			Cliente cliente = new Cliente();
			cliente.setEndereco("rua xyz" );
			cliente.setNome("cliente_criado_em_" + new Date().toString());
			clienteService.salvar(cliente);
			System.out.println("-> orquestração: cliente criado");
		}
		
		vendasService.salvarVenda(venda);
		System.out.println("-> orquestração: salvando a venda");
		// enviando mensagem para o brocker.
		rabbitTemplate.convertAndSend("",exchange,venda);
		return ResponseEntity.ok(true);
	}
	
	@RequestMapping(value = "/v1/teste", method = RequestMethod.GET)	
		public void teste(){
		rabbitTemplate.convertAndSend("", exchange, "teste");
	}
}
