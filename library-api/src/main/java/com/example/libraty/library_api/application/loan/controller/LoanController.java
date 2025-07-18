package com.example.libraty.library_api.application.loan.controller;

import com.example.libraty.library_api.application.common.DTO.ResponseDTO;
import com.example.libraty.library_api.application.loan.DTO.LoanDTO;
import com.example.libraty.library_api.application.loan.DTO.LoanResponseDTO;
import com.example.libraty.library_api.domain.loan.usecase.interfaces.CreateLoanUseCase;
import com.example.libraty.library_api.domain.loan.usecase.interfaces.GetAllLoansUseCase;
import com.example.libraty.library_api.domain.loan.usecase.interfaces.ReturnLoanUseCase;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/loans")
@RequiredArgsConstructor
@Hidden
public class LoanController {

    private final CreateLoanUseCase createLoanUseCase;
    private final ReturnLoanUseCase returnLoanUseCase;
    private final GetAllLoansUseCase getAllLoansUseCase;

    @PostMapping
    public ResponseEntity<ResponseDTO> create(@RequestBody LoanDTO dto) {
        LoanDTO result = LoanDTO.fromDomain(
                createLoanUseCase.execute(
                        new CreateLoanUseCase.Command(dto.toDomain())
                )
        );
        return new ResponseEntity<>(new LoanResponseDTO<>(result), HttpStatus.CREATED);
    }

    @PutMapping("/{id}/return")
    public ResponseEntity<Void> returnBook(@PathVariable("id") UUID id) {
        returnLoanUseCase.execute(
                new ReturnLoanUseCase.Command(id)
        );
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<ResponseDTO> getAll() {
        List<LoanDTO> result = getAllLoansUseCase.execute()
                .stream()
                .map(LoanDTO::fromDomain)
                .toList();
        return ResponseEntity.ok(new LoanResponseDTO<>(result));
    }
}