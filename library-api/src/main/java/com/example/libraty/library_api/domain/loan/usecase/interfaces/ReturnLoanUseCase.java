package com.example.libraty.library_api.domain.loan.usecase.interfaces;

import com.example.libraty.library_api.domain.loan.model.Loan;

import java.util.UUID;

public interface ReturnLoanUseCase {
    Loan execute(Command command);
    record Command(UUID loanId) {}
}
