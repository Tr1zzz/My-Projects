package com.example.libraty.library_api.domain.book.usecase.interfaces;

import com.example.libraty.library_api.domain.book.model.Book;

public interface UpdateBookUseCase {
    Book execute(Command command);
    record Command(Book book) {}
}