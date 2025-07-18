package com.example.libraty.library_api.domain.common.model;

import lombok.With;

import java.util.Date;
import java.util.UUID;

public record BaseModel(
        @With UUID id,
        @With Date created,
        @With Date modified,
        @With String status
) {}