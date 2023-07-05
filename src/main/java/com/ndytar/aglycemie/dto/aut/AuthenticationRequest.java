package com.ndytar.aglycemie.dto.aut;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationResponseType;

@Data
@Getter
@Setter
@Builder
public class AuthenticationRequest {
    private  String login;
    private  String password;
    private  String autType;
    private  boolean isRefreshToken;
    private  String refreshToken;
}
