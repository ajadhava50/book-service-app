package com.epam.gpop.service;

import com.epam.gpop.dto.BookDto;

import java.util.List;

/**
 * @author Abhijeet Jadhav
 * 04-06-2021
 */
public interface BookService {
    BookDto getBook(Long book_id);

    List<BookDto> getBooks();

    BookDto createBook(BookDto book);

    void deleteBook(Long book_id);

    BookDto updateBook(Long book_id,BookDto bookDto);
}
