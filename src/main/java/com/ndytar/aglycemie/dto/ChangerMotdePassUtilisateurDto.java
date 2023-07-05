package com.ndytar.aglycemie.dto;

import lombok.*;

@Builder
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChangerMotdePassUtilisateurDto {
    private String motDepasse;
    private String motDepasse1;
    private String mail;
    
    

}
