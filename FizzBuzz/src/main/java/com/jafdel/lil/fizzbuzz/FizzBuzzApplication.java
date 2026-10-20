package com.jafdel.lil.fizzbuzz;

import org.springframework.boot.CommandLineRunner;import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FizzBuzzApplication {

    public static void main(String[] args) {
        SpringApplication.run(FizzBuzzApplication.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        return args -> {
            for (int i=1; i<=Integer.parseInt(args[0]); i++) {
                String str = "";
                if (i % 3 == 0 || i % 5 == 0) {
                    if (i % 3 == 0)
                        str += "Fizz";
                    if (i % 5 == 0)
                        str += "Buzz";
                } else
                    str = String.valueOf(i);
                IO.println(str);
            }
        };
    }
}
