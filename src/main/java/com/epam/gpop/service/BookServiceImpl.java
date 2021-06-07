package com.epam.gpop.service;

import com.epam.gpop.dto.BookDto;
import com.epam.gpop.entity.Book;
import com.epam.gpop.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Abhijeet Jadhav
 * 04-06-2021
 */
@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookDto getBook(Long book_id) {
        Optional<Book> book = bookRepository.findById(book_id);
        return book.isPresent() ? convertToDto(book.get()) : null;
    }

    @Override
    public List<BookDto> getBooks() {
        return bookRepository.findAll().
                stream()
                .map(usr -> convertToDto(usr))
                .collect(Collectors.toList());
    }

    @Override
    public BookDto createBook(BookDto bookDto) {
        Book book = convertToEntity(bookDto);
        book.setCreated(new Date());
        return convertToDto(bookRepository.save(book));
    }

    @Override
    public void deleteBook(Long book_id) {
        bookRepository.deleteById(book_id);
    }

    @Override
    public BookDto updateBook(Long book_id,BookDto bookDto) {
        bookDto.setBook_id(book_id);
        Book book = bookRepository.save(convertToEntity(bookDto));
        return convertToDto(book);
    }

    private Book convertToEntity(BookDto bookDto) {
        Book bookEntity = new Book();
        bookEntity.setBook_id(bookDto.getBook_id());
        bookEntity.setName(bookDto.getName());
        bookEntity.setUpdated(new Date());
       return bookEntity;
    }

    private BookDto convertToDto(Book bookEntity) {
        BookDto bookDto = new BookDto();
        bookDto.setBook_id(bookEntity.getBook_id());
        bookDto.setName(bookEntity.getName());
        bookDto.setCreated(bookEntity.getCreated());
        bookDto.setUpdated(bookEntity.getUpdated());
        return bookDto;
    }
}
