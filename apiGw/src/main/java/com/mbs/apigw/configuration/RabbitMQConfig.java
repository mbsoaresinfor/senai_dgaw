package com.mbs.apigw.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;

@Configuration
public class RabbitMQConfig {
	static final String topicExchangeName = "vendas";

	  static final String queueName = "vendas";

	  @Bean
	  Queue queue() {
	    return new Queue(queueName, true);
	  }

	  @Bean
	  DirectExchange exchange() {
	    return new DirectExchange(topicExchangeName);
	  }

	  @Bean
	  Binding binding(Queue queue, DirectExchange exchange) {
	    return BindingBuilder
	    		.bind(queue)
	    		.to(exchange)
	    		.with("routing-key-teste");
	  }
	  
	  @Bean
		public MessageConverter jsonMessageConverter() {
			return new Jackson2JsonMessageConverter();
		}

		
		@Bean
		public AmqpTemplate rabbitTemplate2(ConnectionFactory connectionFactory) {
			final RabbitTemplate rabbitTemplate =
					new RabbitTemplate(connectionFactory);
			rabbitTemplate.setMessageConverter(jsonMessageConverter());
			return rabbitTemplate;
		}
	
    
}
