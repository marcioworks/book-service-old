package com.example.bookservice.controller;

import com.example.bookservice.model.Book;
import com.example.bookservice.proxy.CambioProxy;
import com.example.bookservice.repository.BookRepository;
import com.example.bookservice.response.Cambio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@Tag(name = "Book endpoint")
@RestController
@RequestMapping("book-service")
public class BookController {

    @Autowired
    private Environment environment;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CambioProxy proxy;

    @Operation(summary = "Find a book by its id.")
    @GetMapping(value = "{id}/{currency}")
    public Book findBook(@PathVariable("id") Long id,
                         @PathVariable("currency") String currency) {

        Book book = bookRepository.findById(id).orElse(null);
        if (book == null) throw new RuntimeException("book not found");

        var cambio= proxy.getCambio(book.getPrice(),"USD",currency);

        var port = environment.getProperty("local.server.port");
        book.setEnvironment("book port: " + port + " cambio port: " + cambio.getEnviroment()+ cambio);
        book.setPrice(cambio.getConvertedValue());
        System.out.println("cambio: " + cambio);
        return book;
    }
}
