package com.example.libraty.library_api.domain.loan.usecase.implementation;

import com.example.libraty.library_api.domain.loan.model.Loan;
import com.example.libraty.library_api.domain.loan.port.LoanPort;
import com.example.libraty.library_api.domain.loan.usecase.interfaces.GetAllLoansUseCase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllLoansUseCaseHandler implements GetAllLoansUseCase {
    private final LoanPort loanPort;

    @Override
    public List<Loan> execute() {
        return loanPort.findAll();
    }
}