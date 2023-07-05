package com.ndytar.aglycemie.services.aut;

import com.ndytar.aglycemie.dto.UtulisateurDto;
import com.ndytar.aglycemie.services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collection;

@Service
public class ApplcationUserDetailService implements UserDetailsService {

    private  UtilisateurService service;
    @Autowired
    public ApplcationUserDetailService(UtilisateurService service) {
        this.service = service;
    }

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
    
     
        UtulisateurDto utulisateurDto = service.findUtilisateurByMail(mail);
      
        

        Collection<GrantedAuthority> authorities = new ArrayList<>();
        utulisateurDto.getRoles().forEach(r -> authorities.add(new SimpleGrantedAuthority(r.getRolenom())));
        return new User(utulisateurDto.getMail(),utulisateurDto.getMotDePasse(),authorities);

    }
}
