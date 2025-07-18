package com.example.libraty.library_api.domain.book.usecase.implementation;

import com.example.libraty.library_api.domain.book.model.Book;
import com.example.libraty.library_api.domain.book.port.BookPort;
import com.example.libraty.library_api.domain.book.usecase.interfaces.CreateBookUseCase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateBookUseCaseHandler implements CreateBookUseCase {

    private final BookPort bookPort;

    @Override
    public Book execute(Command command) {
        return bookPort.create(command.book());
    }
}