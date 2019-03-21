package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final QuoteService quoteService;

    @Autowired
    public Controller(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping(value = "/")
    public String welcome() {
        return "Backend is ready to accept post requests!";
    }

    @PostMapping(value = "/")
    public ApiResponse getQuote(@RequestBody ApiRequest request) {
        return quoteService.getQuote(request.getValue());
    }
}
