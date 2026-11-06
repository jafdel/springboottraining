package com.jafdel.lil.roomclr;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.restclient.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;
import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

@SpringBootApplication
public class RoomClrApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoomClrApplication.class, args);
    }

    private static final String QUEUE_NAME = "room-cleaner";
    private static final String EXCHANGE_NAME = "operations";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME, false);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("landon.#");
    }

    @Bean
    public RestClient restClient() {
        return RestClient.builder().baseUrl("http://localhost:8080").build();
    }

    @Bean
    public CommandLineRunner run(RestClient restClient, RabbitTemplate template, ObjectMapper mapper) {
        return args -> {
            ResponseEntity<List<Room>> rooms = restClient.get().uri("/api/rooms").accept(MediaType.APPLICATION_JSON).retrieve().toEntity(new ParameterizedTypeReference<List<Room>>(){});
            rooms.getBody().forEach(r -> {
                AsyncPayload payload = new AsyncPayload();
                payload.setId(r.getId());
                payload.setModel("ROOM");
                try {
                    template.convertAndSend("operations", "landon.rooms.cleaner", mapper.writeValueAsString(payload));
                } catch (JacksonException e) {
                    throw new RuntimeException(e);
                }
            });
        };
    }

}
