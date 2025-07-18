package com.example.libraty.library_api.domain.book.usecase.implementation;

import com.example.libraty.library_api.domain.book.port.BookPort;
import com.example.libraty.library_api.domain.book.usecase.interfaces.DeleteBookUseCase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteBookUseCaseHandler implements DeleteBookUseCase {
    private final BookPort bookPort;

    @Override
    public void execute(Command command) {
        bookPort.delete(command.id());
    }
}
