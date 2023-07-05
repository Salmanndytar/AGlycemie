package com.ndytar.aglycemie.services;


import com.ndytar.aglycemie.dto.aut.AuthenticationRequest;
import com.ndytar.aglycemie.dto.aut.AuthenticationResponse;

public interface AuthenticatService {


AuthenticationResponse login(AuthenticationRequest request);
int chekDateToken (AuthenticationResponse response);

}
