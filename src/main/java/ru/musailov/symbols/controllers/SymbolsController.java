package ru.musailov.symbols.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    public SymbolsController(SymbolsService service) {
        this.service = service;
    }

    @PostMapping()
    public Answer getAnswer(@RequestBody Request request) {
        return service.getAnswer(request);
    }
}
