package com.mbs.notificacaoServices;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.mbs.notificacaoServices.entidades.Venda;
import com.mbs.notificacaoServices.services.EmailService;

@Component
public class ProdutoListener {

	@Value("${queue}")
	String queue;
	
	@Autowired
	private EmailService emailService;
	
	@RabbitListener(queues = {"${queue}"})
    public void receive(@Payload String fileBody) {

		System.out.println("Mensagem recebida da fila " + queue + ": " +  fileBody);
		
		// transformando string para json
		Venda vendas = new Gson().fromJson(fileBody, Venda.class);
		
		System.out.println("Nome do Produto: " + vendas.getNomeProduto());
		System.out.println("Status: " + vendas.getStatus());
		System.out.println("Email: " + vendas.getEmail());
		System.out.println("##############################");
		
		emailService.enviar(criarCorpoEmail(vendas),
				"Status de Venda", "", vendas.getEmail());
    }
	
	private String criarCorpoEmail(Venda venda) {
		StringBuilder mensagem = new StringBuilder();
		mensagem
		.append("Ola, cliente\n")
		.append("vc comprou o produto ").append(venda.getNomeProduto()).append("\n")
		.append("seu status é: ").append(venda.getStatus());
		return mensagem.toString();
	}
}
