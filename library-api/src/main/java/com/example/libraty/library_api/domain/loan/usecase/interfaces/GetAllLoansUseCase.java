package com.example.libraty.library_api.domain.loan.usecase.interfaces;

import com.example.libraty.library_api.domain.loan.model.Loan;

import java.util.List;

public interface GetAllLoansUseCase {
    List<Loan> execute();
}