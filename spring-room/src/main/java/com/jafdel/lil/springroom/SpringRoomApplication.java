package com.jafdel.lil.springroom;

import com.jafdel.lil.springroom.data.repository.EmployeeRepository;
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
    public CommandLineRunner run (RoomRepository roomRepository, EmployeeRepository employeeRepository) {
        return args -> {
            findAll(roomRepository);
            findAll(employeeRepository);
        };
    }

    @Transactional
    private void findAll(RoomRepository roomRepository) {
        roomRepository.findAll().forEach(IO::println);
    }

    @Transactional
    private void findAll(EmployeeRepository employeeRepository) {
        employeeRepository.findAll().forEach(IO::println);
    }
}
