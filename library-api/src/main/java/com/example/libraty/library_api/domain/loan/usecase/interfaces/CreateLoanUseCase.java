package com.example.libraty.library_api.domain.loan.usecase.interfaces;

import com.example.libraty.library_api.domain.loan.model.Loan;

public interface CreateLoanUseCase {
    Loan execute(Command command);
    record Command(Loan loan) {}
}
