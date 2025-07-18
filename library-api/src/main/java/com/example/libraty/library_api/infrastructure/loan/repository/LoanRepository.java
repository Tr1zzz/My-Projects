package com.example.libraty.library_api.infrastructure.loan.repository;

import com.example.libraty.library_api.infrastructure.loan.entity.LoanEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LoanRepository extends JpaRepository<LoanEntity, UUID> { }