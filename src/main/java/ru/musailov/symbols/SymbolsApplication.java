package ru.musailov.symbols;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class SymbolsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SymbolsApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate) {
		return args -> {
			for (int i=0; i < 100; i++) {
				kafkaTemplate.send("user_request", Integer.toString(i));
			}
		};
	}

}
