package com.jafdel.lil.roomclr;

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

import java.util.List;

@SpringBootApplication
public class RoomClrApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoomClrApplication.class, args);
    }

    @Bean
    public RestClient restClient() {
        return RestClient.builder().baseUrl("http://localhost:8080").build();
    }

    @Bean
    public CommandLineRunner run(RestClient restClient) {
        return args -> {
            ResponseEntity<List<Room>> rooms = restClient.get().uri("/api/rooms").accept(MediaType.APPLICATION_JSON).retrieve().toEntity(new ParameterizedTypeReference<List<Room>>(){});
            rooms.getBody().forEach(IO::println);
        };
    }

}
