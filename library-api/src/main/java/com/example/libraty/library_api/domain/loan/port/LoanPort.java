package com.example.libraty.library_api.domain.loan.port;

import com.example.libraty.library_api.domain.loan.model.Loan;

import java.util.List;
import java.util.UUID;

public interface LoanPort {
    Loan create(Loan loan);
    Loan returnLoan(UUID loanId);
    List<Loan> findAll();
}