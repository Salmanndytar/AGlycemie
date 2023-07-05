package com.ndytar.aglycemie.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SendMailDto {
    private  String to;
    private  String message;
    private  String object;


}
