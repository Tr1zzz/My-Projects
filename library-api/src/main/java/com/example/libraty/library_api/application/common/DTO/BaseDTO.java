package com.example.libraty.library_api.application.common.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record BaseDTO(
        @JsonProperty("id") UUID id,
        @JsonProperty("created") Date created,
        @JsonProperty("modified") Date modified,
        @JsonProperty("status") String status
) { }