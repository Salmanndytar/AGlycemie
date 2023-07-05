package com.ndytar.aglycemie.dto;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Builder
@Data
public class AbstractionDto {
    private Integer id;

    private Instant creationDate;

    private Instant lastModifiedDate;
}
