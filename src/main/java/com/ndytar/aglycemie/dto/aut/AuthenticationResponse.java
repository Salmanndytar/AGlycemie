package com.ndytar.aglycemie.dto.aut;

import lombok.*;

import java.time.Instant;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthenticationResponse {
    private  String accessToken;
    private  String accessRefreshToken;
    private String roles;
    private Instant  expirDateToken;
    private Instant  expirDateRefreshToken;

}
