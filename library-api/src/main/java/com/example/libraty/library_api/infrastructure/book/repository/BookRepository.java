package com.example.libraty.library_api.infrastructure.book.repository;

import com.example.libraty.library_api.infrastructure.book.entity.BookEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, UUID> { }