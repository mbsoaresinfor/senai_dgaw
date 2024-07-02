package com.mbs.notificacaoServices;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class RevisaoListener {

	@Value("${queue_revisao}")
	String queue;
	
	@RabbitListener(queues = {"${queue_revisao}"})
    public void receive(@Payload String fileBody) {
		System.out.println("Mensagem recebida da fila " + queue + ": " +  fileBody);
    }
}
