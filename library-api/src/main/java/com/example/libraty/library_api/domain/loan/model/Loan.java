package com.example.libraty.library_api.domain.loan.model;

import com.example.libraty.library_api.domain.common.model.BaseModel;

import lombok.With;

import java.time.LocalDateTime;
import java.util.UUID;

public record Loan(
        @With BaseModel baseModel,
        @With UUID bookId,
        @With UUID userId,
        @With LocalDateTime loanDate,
        @With LocalDateTime returnDate
) {}
