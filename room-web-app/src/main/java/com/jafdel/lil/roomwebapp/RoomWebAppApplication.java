package com.jafdel.lil.roomwebapp;

import com.jafdel.lil.roomwebapp.data.repository.RoomRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication(scanBasePackages={"org.hibernate"})
@EnableJpaAuditing
@EnableJpaRepositories(basePackages={"com.jafdel.lil.roomwebapp.data.repository"}, entityManagerFactoryRef = "entityManagerFactory", transactionManagerRef = "transactionManager")
//@EnableAutoConfiguration
//@EnableTransactionManagement
//@ComponentScan(basePackages={"com.jafdel.lil.roomwebapp.data.repository"})
@EntityScan(basePackages={"com.jafdel.lil.roomwebapp.data.entity"})
public class RoomWebAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoomWebAppApplication.class, args);
    }

    @PersistenceContext
    private EntityManager em;

    @Bean
    public CommandLineRunner run(RoomRepository roomRepository) {
        return args -> findAll(roomRepository);
    }

    @Transactional
    private void findAll(RoomRepository roomRepository) {
        roomRepository.findAll().forEach(IO::println);
    }
}
