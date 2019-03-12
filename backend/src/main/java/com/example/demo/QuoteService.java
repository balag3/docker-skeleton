package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class QuoteService {

    @Value("${api.host}")
    private String API_HOST;

    private final RestTemplate restTemplate;

    //private final QuoteRepository quoteRepository;

    @Autowired
    public QuoteService(RestTemplate restTemplate
                        //QuoteRepository quoteRepository
    ) {
        this.restTemplate = restTemplate;
        //this.quoteRepository = quoteRepository;
    }

    public ApiResponse getQuote(String word) {
        ApiResponse springResponse = new ApiResponse("No quote found with this keyword!");

//        Optional<Quote> existingQuote =  quoteRepository.findByWord(word);
//        if (existingQuote.isPresent()) {
//            springResponse.setValue(existingQuote.get().getQuote());
//            return springResponse;
//        }

        ApiResponse response = restTemplate.getForObject("http://" + API_HOST + ":3000/" + word, ApiResponse.class);

        if (response != null) {
            Quote quote = new Quote();
            quote.setWord(word);
            quote.setQuote(response.getValue());
            //quoteRepository.save(quote);
            springResponse.setValue(quote.getQuote());
        }
        return springResponse;
    }
}
