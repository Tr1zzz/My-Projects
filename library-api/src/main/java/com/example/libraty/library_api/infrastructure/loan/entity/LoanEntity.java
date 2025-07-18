package com.example.libraty.library_api.infrastructure.loan.entity;

import com.example.libraty.library_api.domain.common.model.BaseModel;
import com.example.libraty.library_api.domain.loan.model.Loan;
import com.example.libraty.library_api.infrastructure.common.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "loan")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class LoanEntity extends BaseEntity {

    @Column(name = "book_id", nullable = false)
    private UUID bookId;

    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @Column(name = "loan_date", nullable = false)
    private LocalDateTime loanDate;

    @Column(name = "return_date")
    private LocalDateTime returnDate;

    public static LoanEntity fromDomain(Loan loan) {
        BaseModel bm = loan.baseModel();
        return new LoanEntity(
                bm.id(),
                bm.status(),
                loan.bookId(),
                loan.userId(),
                loan.loanDate(),
                loan.returnDate()
        );
    }

    public LoanEntity(UUID id,
                      String status,
                      UUID bookId,
                      UUID userId,
                      LocalDateTime loanDate,
                      LocalDateTime returnDate
    ) {
        super(id, status);
        this.bookId = bookId;
        this.userId = userId;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
    }

    public Loan toDomain() {
        return new Loan(
                toBaseModel(),
                bookId,
                userId,
                loanDate,
                returnDate
        );
    }
}