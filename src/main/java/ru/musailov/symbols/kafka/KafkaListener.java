package ru.musailov.symbols.kafka;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;

@Component
public class KafkaListener {

    @org.springframework.kafka.annotation.KafkaListener(
            topics = "user_request",
            groupId = "requestListener"
    )
    void listener(String data) {
        System.out.println("Listener receieved: " + data);
    }
}
