package ru.musailov.symbols.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.musailov.symbols.models.*;
import ru.musailov.symbols.service.SymbolsService;

@RestController
@RequestMapping("/main")
public class SymbolsController {
    private final SymbolsService service;

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public SymbolsController(SymbolsService service, KafkaTemplate<String, String> kafkaTemplate) {
        this.service = service;
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping()
    public Answer getAnswer(@RequestBody Request request) {
        kafkaTemplate.send("user_request", request.getString());
        return service.getAnswer(request);
    }
}
