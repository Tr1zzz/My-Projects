package com.example.libraty.library_api.domain.book.model;

import com.example.libraty.library_api.domain.common.model.BaseModel;

import lombok.With;

public record Book(
        @With BaseModel baseModel,
        @With String title,
        @With String author,
        @With Integer publishedYear
) {}