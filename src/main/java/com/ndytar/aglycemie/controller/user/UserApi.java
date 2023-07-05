package com.ndytar.aglycemie.controller.user;

import com.ndytar.aglycemie.dto.UtulisateurDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ndytar.aglycemie.utils.Constant.API_ROOT;


@RequestMapping(API_ROOT+"/utilisateurs")
public interface UserApi {
@GetMapping(value = "/mail/{mail}",produces = MediaType.APPLICATION_JSON_VALUE)
UtulisateurDto findUtilisateurByMail(@PathVariable String mail);

@GetMapping(value = "/id/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
UtulisateurDto findUtilisateurById(@PathVariable Integer id);

@PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    @PostAuthorize("hasAuthority('ADMIN')")

UtulisateurDto sav(@RequestBody UtulisateurDto utulisateurDto);


@GetMapping(value = "/search",produces = MediaType.APPLICATION_JSON_VALUE)
@ApiOperation(value = "kyword",notes = "Mehode pour chercher un utilisateur via son nom",response = UtulisateurDto.class)
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "l'utilisateur a ete trouve"),
        @ApiResponse(code = 404, message = "l'utilisateur avec info fourni n'existe pas")
})
List<UtulisateurDto> findUtilisateurByNomContains(@RequestParam(name = "kyword", defaultValue = "") String kyword);


}
