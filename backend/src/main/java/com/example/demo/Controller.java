package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping(value = "/")
    public ApiResponse getPost(@RequestBody ApiRequest request) {
        return quoteService.getQuote(request.getValue());
    }
}
