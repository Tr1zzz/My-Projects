package com.example.libraty.library_api.domain.book.usecase.interfaces;

import com.example.libraty.library_api.domain.book.model.Book;

import java.util.UUID;

public interface GetBookByIdUseCase {
    Book execute(Command command);
    record Command(UUID id) {}
}