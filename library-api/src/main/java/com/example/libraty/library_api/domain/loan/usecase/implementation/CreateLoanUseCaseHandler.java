package com.example.libraty.library_api.domain.loan.usecase.implementation;

import com.example.libraty.library_api.domain.loan.model.Loan;
import com.example.libraty.library_api.domain.loan.port.LoanPort;
import com.example.libraty.library_api.domain.loan.usecase.interfaces.CreateLoanUseCase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateLoanUseCaseHandler implements CreateLoanUseCase {
    private final LoanPort loanPort;

    @Override
    public Loan execute(Command command) {
        return loanPort.create(command.loan());
    }
}