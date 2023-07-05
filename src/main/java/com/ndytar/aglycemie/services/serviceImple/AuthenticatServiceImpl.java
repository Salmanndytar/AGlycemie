package com.ndytar.aglycemie.services.serviceImple;
import com.fasterxml.jackson.databind.DatabindException;
import com.ndytar.aglycemie.dto.aut.AuthenticationRequest;
import com.ndytar.aglycemie.dto.aut.AuthenticationResponse;
import com.ndytar.aglycemie.services.AuthenticatService;
import com.ndytar.aglycemie.services.aut.ApplcationUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collection;

import java.util.Date;
import java.util.stream.Collectors;

@Service
public class AuthenticatServiceImpl implements AuthenticatService {

AuthenticationManager authenticationManager;

private  ApplcationUserDetailService userDetailService;


JwtEncoder jwtEncoder;

JwtDecoder jwtDecoder;

AuthenticationResponse authenticationResponse = new AuthenticationResponse();
@Autowired
public AuthenticatServiceImpl(AuthenticationManager authenticationManager,
                              ApplcationUserDetailService userDetailService,
                              JwtEncoder jwtEncoder, JwtDecoder jwtDecoder)
{
    this.authenticationManager = authenticationManager;
    this.userDetailService = userDetailService;
    this.jwtEncoder = jwtEncoder;
    this.jwtDecoder = jwtDecoder;

}
     Instant createDate, expirDate;
@Override
public AuthenticationResponse login(AuthenticationRequest request) {
    String username = null;
    String roles = null;
    if (request.getAutType().equals("password")) {
       
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getLogin(), request.getPassword())
        ) ;
        username = authentication.getName();
        roles =  authentication.getAuthorities()
                         .stream().map(GrantedAuthority::getAuthority)
                         .collect(Collectors.joining(" "));
    }
    else if (request.getAutType().equals("refreshToken")){
        Jwt decodeJwt = jwtDecoder.decode(request.getRefreshToken());
        username = decodeJwt.getSubject();
        UserDetails userDetails = userDetailService.loadUserByUsername(username);
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        roles =   authorities
                          .stream().map(GrantedAuthority::getAuthority)
                          .collect(Collectors.joining(" "));
    }
    

    
    Instant instant = Instant.now();
    JwtClaimsSet jwtClaimsSet = JwtClaimsSet.builder()
                                        .subject(username)
                                        .issuedAt(instant)
                                        .expiresAt(instant.plus(request.isRefreshToken()?2:3, ChronoUnit.MINUTES))
                                        .issuer("*")
                                        .claim("scope",roles)
                                        .build();
    String jwtAccessToken = jwtEncoder.encode(JwtEncoderParameters.from(jwtClaimsSet)).getTokenValue();
    Jwt decodeJwt = jwtDecoder.decode(jwtAccessToken);
    createDate  = decodeJwt.getExpiresAt();
    authenticationResponse.setRoles(roles);
    authenticationResponse.setExpirDateToken(createDate);
    
   
   
    authenticationResponse.setAccessToken(jwtAccessToken);

    if(request.isRefreshToken()){
        JwtClaimsSet jwtClaimsSetRefreshToken = JwtClaimsSet.builder()
                                                        .subject(username)
                                                        .issuedAt(instant)
                                                        .expiresAt(instant.plus(7000, ChronoUnit.HOURS))
                                                        .issuer("*")
                                                        .build();
        String jwtAccessRefreshToken = jwtEncoder.encode(JwtEncoderParameters.from(jwtClaimsSetRefreshToken)).getTokenValue();
        authenticationResponse.setAccessRefreshToken(jwtAccessRefreshToken);
    }
    return authenticationResponse;
}
@Override
public int  chekDateToken(AuthenticationResponse response){
    response.setExpirDateToken(Instant.parse(response.getExpirDateToken().toString()));
  
    return response.getExpirDateToken().compareTo(Instant.now());
}
}
