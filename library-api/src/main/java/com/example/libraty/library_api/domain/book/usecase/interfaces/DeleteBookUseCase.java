package com.example.libraty.library_api.domain.book.usecase.interfaces;

import java.util.UUID;

public interface DeleteBookUseCase {
    void execute(Command command);
    record Command(UUID id) {}
}
