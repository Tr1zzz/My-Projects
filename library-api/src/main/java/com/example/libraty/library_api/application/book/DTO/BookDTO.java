package com.example.libraty.library_api.application.book.DTO;

import com.example.libraty.library_api.application.common.DTO.BaseDTO;
import com.example.libraty.library_api.domain.book.model.Book;
import com.example.libraty.library_api.domain.common.model.BaseModel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import java.util.Date;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record BookDTO(
        @JsonUnwrapped BaseDTO baseDTO,
        @JsonProperty("title") String title,
        @JsonProperty("author") String author,
        @JsonProperty("publishedYear") Integer publishedYear
) {
    @JsonCreator
    public BookDTO(
            @JsonProperty("id") UUID id,
            @JsonProperty("created") Date created,
            @JsonProperty("modified") Date modified,
            @JsonProperty("status") String status,
            @JsonProperty("title") String title,
            @JsonProperty("author") String author,
            @JsonProperty("publishedYear") Integer publishedYear
    ) {
        this(new BaseDTO(id, created, modified, status), title, author, publishedYear);
    }

    public Book toDomain() {
        BaseModel bm = new BaseModel(
                baseDTO.id(),
                baseDTO.created(),
                baseDTO.modified(),
                baseDTO.status()
        );
        return new Book(bm, title, author, publishedYear);
    }

    public static BookDTO fromDomain(Book book) {
        return new BookDTO(
                book.baseModel().id(),
                book.baseModel().created(),
                book.baseModel().modified(),
                book.baseModel().status(),
                book.title(),
                book.author(),
                book.publishedYear()
        );
    }
}