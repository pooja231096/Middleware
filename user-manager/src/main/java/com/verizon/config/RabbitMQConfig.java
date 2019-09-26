package com.verizon.config;
import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class RabbitMQConfig {
	
	@Bean(name= "directQueue")
	public Queue queue() {
		return new Queue("RegistrationDataQueue");
	}
	@Bean(name= "directQueue1")
	public Queue queue1() {
		return new Queue("PasswordResetQueue");
	}
	
	@Bean(name= "directExchange")
	 public DirectExchange exchange() {
		Map<String, Object> args = new HashMap<String, Object>();
        args.put("x-delayed-type", "direct");
		return new DirectExchange("RegistrationExchange",true,false,args);
	}
	
	@Bean(name= "directExchange1")
	 public DirectExchange exchange1() {
		Map<String, Object> args = new HashMap<String, Object>();
        args.put("x-delayed-type", "direct");
		return new DirectExchange("PasswordExchange",true,false,args);
	}
	
	@Bean(name = "directBinding")
	public Binding binding() {
		return BindingBuilder.bind(queue()).to(exchange()).with("RegistrationRoutingKey");
	}
	
	@Bean(name = "directBinding1")
	public Binding binding1() {
		return BindingBuilder.bind(queue1()).to(exchange1()).with("PasswordRoutingKey");
	}
	
	@Bean
	public MessageConverter messageConverter() {
		return new Jackson2JsonMessageConverter();
	}
	
	@Bean
	public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(messageConverter());
		return rabbitTemplate;
		
	}
}
