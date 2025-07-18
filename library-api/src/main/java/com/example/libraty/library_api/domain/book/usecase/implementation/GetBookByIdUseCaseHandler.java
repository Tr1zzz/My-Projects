package com.example.libraty.library_api.domain.book.usecase.implementation;

import com.example.libraty.library_api.domain.book.model.Book;
import com.example.libraty.library_api.domain.book.port.BookPort;
import com.example.libraty.library_api.domain.book.usecase.interfaces.GetBookByIdUseCase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetBookByIdUseCaseHandler implements GetBookByIdUseCase {
    private final BookPort bookPort;

    @Override
    public Book execute(Command command) {
        return bookPort.getById(command.id());
    }
}