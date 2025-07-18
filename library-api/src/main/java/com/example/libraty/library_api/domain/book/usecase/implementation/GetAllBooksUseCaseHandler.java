package com.example.libraty.library_api.domain.book.usecase.implementation;

import com.example.libraty.library_api.domain.book.model.Book;
import com.example.libraty.library_api.domain.book.port.BookPort;
import com.example.libraty.library_api.domain.book.usecase.interfaces.GetAllBooksUseCase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllBooksUseCaseHandler implements GetAllBooksUseCase {
    private final BookPort bookPort;

    @Override
    public List<Book> execute() {
        return bookPort.findAll();
    }
}