package com.example.libraty.library_api.infrastructure.book;

import com.example.libraty.library_api.domain.book.exception.BookException;
import com.example.libraty.library_api.domain.book.model.Book;
import com.example.libraty.library_api.domain.book.port.BookPort;
import com.example.libraty.library_api.infrastructure.book.entity.BookEntity;
import com.example.libraty.library_api.infrastructure.book.repository.BookRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookAdapter implements BookPort {

    private final BookRepository bookRepository;

    @Override
    public Book create(Book book) {
        Book toSave = book.withBaseModel(
                book.baseModel()
                        .withId(null)
                        .withStatus("NEW")
        );
        BookEntity saved = bookRepository.save(
                BookEntity.fromDomain(toSave)
        );
        return saved.toDomain();
    }

    @Override
    public Book update(Book book) {
        UUID id = book.baseModel().id();
        BookEntity existing = bookRepository.findById(id)
                .orElseThrow(() -> new BookException("Book with id=" + id + " not found"));

        existing.setTitle(book.title());
        existing.setAuthor(book.author());
        existing.setPublishedYear(book.publishedYear());

        BookEntity saved = bookRepository.save(existing);
        return saved.toDomain();
    }

    @Override
    public Book getById(UUID id) {
        return bookRepository.findById(id)
                .map(BookEntity::toDomain)
                .orElseThrow(() -> new BookException("Book with id=" + id + " not found"));
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll()
                .stream()
                .map(BookEntity::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(UUID id) {
        if (!bookRepository.existsById(id)) {
            throw new BookException("Book with id=" + id + " not found");
        }
        bookRepository.deleteById(id);
    }
}