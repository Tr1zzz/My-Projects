package com.example.libraty.library_api.application.book.controller;


import com.example.libraty.library_api.application.book.DTO.BookDTO;
import com.example.libraty.library_api.application.book.DTO.BookResponseDTO;
import com.example.libraty.library_api.application.common.DTO.ResponseDTO;
import com.example.libraty.library_api.domain.book.model.Book;
import com.example.libraty.library_api.domain.book.usecase.interfaces.*;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
@Hidden
public class BookController {

    private final CreateBookUseCase createBookUseCase;
    private final GetAllBooksUseCase getAllBooksUseCase;
    private final GetBookByIdUseCase getBookByIdUseCase;
    private final UpdateBookUseCase updateBookUseCase;
    private final DeleteBookUseCase deleteBookUseCase;

    @GetMapping
    public ResponseEntity<ResponseDTO> getAll() {
        List<BookDTO> result = getAllBooksUseCase.execute()
                .stream()
                .map(BookDTO::fromDomain)
                .toList();
        return ResponseEntity.ok(new BookResponseDTO<>(result));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getById(@PathVariable("id") UUID id) {
        BookDTO dto = BookDTO.fromDomain(
                getBookByIdUseCase.execute(
                        new GetBookByIdUseCase.Command(id)
                )
        );
        return ResponseEntity.ok(new BookResponseDTO<>(dto));
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> create(@RequestBody BookDTO dto) {
        BookDTO result = BookDTO.fromDomain(
                createBookUseCase.execute(
                        new CreateBookUseCase.Command(dto.toDomain())
                )
        );
        return new ResponseEntity<>(new BookResponseDTO<>(result), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO> update(@PathVariable("id") UUID id,
                                              @RequestBody BookDTO dto) {
        Book book = dto.toDomain();
        book = book.withBaseModel(
                book.baseModel().withId(id)
        );
        BookDTO result = BookDTO.fromDomain(
                updateBookUseCase.execute(
                        new UpdateBookUseCase.Command(book)
                )
        );
        return ResponseEntity.ok(new BookResponseDTO<>(result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") UUID id) {
        deleteBookUseCase.execute(
                new DeleteBookUseCase.Command(id)
        );
        return ResponseEntity.noContent().build();
    }
}