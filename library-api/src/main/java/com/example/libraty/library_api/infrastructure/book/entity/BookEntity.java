package com.example.libraty.library_api.infrastructure.book.entity;

import com.example.libraty.library_api.domain.book.model.Book;
import com.example.libraty.library_api.domain.common.model.BaseModel;
import com.example.libraty.library_api.infrastructure.common.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BookEntity extends BaseEntity {

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(name = "published_year", nullable = false)
    private Integer publishedYear;

    public static BookEntity fromDomain(Book book) {
        BaseModel bm = book.baseModel();
        BookEntity e = new BookEntity(
                bm.id(),
                bm.status(),
                book.title(),
                book.author(),
                book.publishedYear()
        );
        return e;
    }

    public BookEntity(UUID id,
                      String status,
                      String title,
                      String author,
                      Integer publishedYear
    ) {
        super(id, status);
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
    }

    public Book toDomain() {
        return new Book(
                this.toBaseModel(),
                this.title,
                this.author,
                this.publishedYear
        );
    }
}
