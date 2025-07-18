package com.example.libraty.library_api.domain.book.usecase.interfaces;

import com.example.libraty.library_api.domain.book.model.Book;

import java.util.List;

public interface GetAllBooksUseCase {
    List<Book> execute();
}