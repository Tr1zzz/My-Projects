package com.example.libraty.library_api.infrastructure.loan;

import com.example.libraty.library_api.domain.common.model.BaseModel;
import com.example.libraty.library_api.domain.loan.exception.LoanException;
import com.example.libraty.library_api.domain.loan.model.Loan;
import com.example.libraty.library_api.domain.loan.port.LoanPort;
import com.example.libraty.library_api.infrastructure.loan.entity.LoanEntity;
import com.example.libraty.library_api.infrastructure.loan.repository.LoanRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LoanAdapter implements LoanPort {

    private final LoanRepository loanRepository;

    @Override
    public Loan create(Loan loan) {
        BaseModel init = loan.baseModel()
                .withId(null)
                .withStatus("NEW");

        LocalDateTime ld = loan.loanDate() != null
                ? loan.loanDate()
                : LocalDateTime.now();

        Loan toSave = loan
                .withBaseModel(init)
                .withLoanDate(ld);
        LoanEntity saved = loanRepository.save(
                LoanEntity.fromDomain(toSave)
        );
        return saved.toDomain();
    }

    @Override
    public Loan returnLoan(UUID loanId) {
        return loanRepository.findById(loanId)
                .map(entity -> {
                    Loan returned = entity.toDomain()
                            .withReturnDate(LocalDateTime.now());
                    BaseModel bm = returned.baseModel()
                            .withModified(new Date())
                            .withStatus("RETURNED");
                    Loan updatedDomain = returned.withBaseModel(bm);

                    LoanEntity toUpdate = LoanEntity.fromDomain(updatedDomain);
                    LoanEntity saved = loanRepository.save(toUpdate);
                    return saved.toDomain();
                })
                .orElseThrow(() -> new LoanException("Loan with id=" + loanId + " not found"));
    }



    @Override
    public List<Loan> findAll() {
        return loanRepository.findAll().stream()
                .map(LoanEntity::toDomain)
                .collect(Collectors.toList());
    }
}