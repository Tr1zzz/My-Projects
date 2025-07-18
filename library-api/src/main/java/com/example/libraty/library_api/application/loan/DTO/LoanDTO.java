package com.example.libraty.library_api.application.loan.DTO;

import com.example.libraty.library_api.application.common.DTO.BaseDTO;
import com.example.libraty.library_api.domain.common.model.BaseModel;
import com.example.libraty.library_api.domain.loan.model.Loan;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record LoanDTO(
        @JsonUnwrapped BaseDTO baseDTO,
        @JsonProperty("bookId") UUID bookId,
        @JsonProperty("userId") UUID userId,
        @JsonProperty("loanDate") LocalDateTime loanDate,
        @JsonProperty("returnDate") LocalDateTime returnDate
) {
    @JsonCreator
    public LoanDTO(
            @JsonProperty("id") UUID id,
            @JsonProperty("created") Date created,
            @JsonProperty("modified") Date modified,
            @JsonProperty("status") String status,
            @JsonProperty("bookId") UUID bookId,
            @JsonProperty("userId") UUID userId,
            @JsonProperty("loanDate") LocalDateTime loanDate,
            @JsonProperty("returnDate") LocalDateTime returnDate
    ) {
        this(
                new BaseDTO(id, created, modified, status),
                bookId,
                userId,
                loanDate,
                returnDate
        );
    }

    public Loan toDomain() {
        BaseModel bm =
                new BaseModel(
                        baseDTO.id(),
                        baseDTO.created(),
                        baseDTO.modified(),
                        baseDTO.status()
                );
        return new Loan(
                bm,
                bookId,
                userId,
                loanDate,
                returnDate
        );
    }

    public static LoanDTO fromDomain(Loan loan) {
        return new LoanDTO(
                loan.baseModel().id(),
                loan.baseModel().created(),
                loan.baseModel().modified(),
                loan.baseModel().status(),
                loan.bookId(),
                loan.userId(),
                loan.loanDate(),
                loan.returnDate()
        );
    }
}