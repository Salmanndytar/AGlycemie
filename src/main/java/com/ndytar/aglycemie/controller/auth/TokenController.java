package com.ndytar.aglycemie.controller.auth;
import com.ndytar.aglycemie.dto.aut.AuthenticationRequest;
import com.ndytar.aglycemie.dto.aut.AuthenticationResponse;
import com.ndytar.aglycemie.services.AuthenticatService;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.ndytar.aglycemie.utils.Constant.API_ROOT;


@RestController
@RequestMapping(API_ROOT+"/auth")
public class TokenController {

AuthenticatService authenticatService;

public TokenController(AuthenticatService authenticatService) {
    this.authenticatService = authenticatService;
}

@PostMapping(value = "/token", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<AuthenticationResponse>JwtToken(@RequestBody AuthenticationRequest request){

    return ResponseEntity.ok(authenticatService.login(request));
      }

@PostMapping(value = "/chekToken",produces = MediaType.APPLICATION_JSON_VALUE)
int chekToken(@RequestBody AuthenticationResponse response) {
    return authenticatService.chekDateToken(response);
}
 
}
