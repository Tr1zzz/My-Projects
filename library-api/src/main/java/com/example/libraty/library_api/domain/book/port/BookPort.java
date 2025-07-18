package com.example.libraty.library_api.domain.book.port;

import com.example.libraty.library_api.domain.book.model.Book;

import java.util.List;
import java.util.UUID;

public interface BookPort {
    Book create(Book book);
    Book update(Book book);
    Book getById(UUID id);
    List<Book> findAll();
    void delete(UUID id);
}