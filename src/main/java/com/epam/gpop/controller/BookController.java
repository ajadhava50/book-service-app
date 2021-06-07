package com.epam.gpop.controller;

import com.epam.gpop.dto.BookDto;
import com.epam.gpop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Abhijeet Jadhav
 * 04-06-2021
 */
@RestController
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    @Autowired
    BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookDto> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/{book_id}")
    public BookDto getBookById(@PathVariable Integer book_id) {
        return bookService.getBook(book_id.longValue());
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public BookDto createBook(@RequestBody BookDto book) {
        return bookService.createBook(book);
    }

    @DeleteMapping("/{book_id}")
    public String deleteBook(@PathVariable Long book_id) {
         bookService.deleteBook(book_id);
         return "book deleted with id:"+book_id;
    }

    @PutMapping(value = "/{book_id}",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public BookDto updateBook(@PathVariable Long book_id,@RequestBody BookDto bookDto) {
        return bookService.updateBook(book_id,bookDto);
    }
}