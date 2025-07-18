package com.example.libraty.library_api.domain.loan.usecase.implementation;

import com.example.libraty.library_api.domain.loan.model.Loan;
import com.example.libraty.library_api.domain.loan.port.LoanPort;
import com.example.libraty.library_api.domain.loan.usecase.interfaces.ReturnLoanUseCase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReturnLoanUseCaseHandler implements ReturnLoanUseCase {
    private final LoanPort loanPort;

    @Override
    public Loan execute(Command command) {
        return loanPort.returnLoan(command.loanId());
    }
}