package com.example.demo;

import lombok.Data;

//@Entity
@Data
public class Quote {

//    @Id
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
//    private Long id;

    private String word;

    private String quote;
}
