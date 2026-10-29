package com.jafdel.lil.springroom;

import com.jafdel.lil.springroom.data.repository.RoomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class SpringRoomApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringRoomApplication.class, args);
    }

    @Bean
    public CommandLineRunner run (RoomRepository roomRepository) {
        return args -> findAll(roomRepository);
    }

    @Transactional
    private void findAll(RoomRepository roomRepository) {
        roomRepository.findAll().forEach(IO::println);
    }
}
