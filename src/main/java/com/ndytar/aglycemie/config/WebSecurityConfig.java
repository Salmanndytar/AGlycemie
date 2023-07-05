package com.ndytar.aglycemie.config;

import com.ndytar.aglycemie.services.aut.ApplcationUserDetailService;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)

public class WebSecurityConfig {

private  RsaKeyConfig rsaKeyConfig;
         
private  ApplcationUserDetailService userDetailService;
//public     PasswordEncoder passwordEncoder;
@Autowired
public WebSecurityConfig(RsaKeyConfig rsaKeyConfig, ApplcationUserDetailService userDetailService
/*,@Lazy PasswordEncoder passwordEncoder*/) {
    this.rsaKeyConfig = rsaKeyConfig;
    this.userDetailService = userDetailService;
   // this.passwordEncoder = passwordEncoder;

}


@Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    
@Bean
public AuthenticationManager authenticationManager(){
   var autProvider = new DaoAuthenticationProvider();
   autProvider.setPasswordEncoder(passwordEncoder());
   autProvider.setUserDetailsService(userDetailService);
   return new ProviderManager(autProvider);
}


@Bean
public SecurityFilterChain filterChain(HttpSecurity httpSecurity)throws Exception {
    return httpSecurity
                   .csrf(AbstractHttpConfigurer::disable)
                   .cors(Customizer.withDefaults())
                   .authorizeRequests(auth ->auth.antMatchers(
                           "/AGlycemie/api/v1/auth/**",
                           "/AGlycemie/api/v1/utilisateurs/create",
                           "/AGlycemie/api/v1/roles/**",
                           "/v2/api-docs",
                           "/v2/api-docs/**",
                           "/swagger-resources",//autoriser tous les resource swagger tel les images...
                           "/swagger-resources/**",
                           "/configuration/ui",//l-interface graphique swgger est une interface preconfiguree
                           "/configuration/security",
                           "/swagger-ui.html",
                           "/webjars/**",
                           "/v3/api-docs/**",//la version de swagger: springfox-boot-starter pour le moment j n'ai ps encore activer
                           "/swagger-ui/**"
                   ).permitAll())
                   .authorizeRequests(auth -> auth.anyRequest().authenticated())
                   .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                   .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
                   .httpBasic(Customizer.withDefaults())
                   .userDetailsService(userDetailService)
                   .build();
     }
     @Bean
     JwtDecoder jwtDecoder(){
       return NimbusJwtDecoder.withPublicKey(rsaKeyConfig.publicKey()).build();
     }
     @Bean
   JwtEncoder jwtEncoder(){
    
       JWK jwk = new RSAKey.Builder(rsaKeyConfig.publicKey()).privateKey(rsaKeyConfig.privateKey()).build();
       JWKSource<SecurityContext> jwkSource = new ImmutableJWKSet<>(new JWKSet(jwk));
    return new NimbusJwtEncoder(jwkSource);
   }


}

