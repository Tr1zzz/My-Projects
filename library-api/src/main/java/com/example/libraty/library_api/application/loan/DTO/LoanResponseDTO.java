package com.example.libraty.library_api.application.loan.DTO;

import com.example.libraty.library_api.application.common.DTO.SuccessResponseDTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record LoanResponseDTO<T>(
        @JsonProperty("body") T body
) implements SuccessResponseDTO<T> {}