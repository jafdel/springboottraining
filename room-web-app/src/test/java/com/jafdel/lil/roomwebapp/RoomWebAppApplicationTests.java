package com.jafdel.lil.roomwebapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(classes = {com.jafdel.lil.roomwebapp.RoomWebAppApplication.class})
@TestPropertySource(properties = {"spring.config.location=classpath:application.properties"})
class RoomWebAppApplicationTests {

    @Test
    void contextLoads() {
    }

}
