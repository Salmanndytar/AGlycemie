package com.ndytar.aglycemie.controller.account;

import com.ndytar.aglycemie.dto.RoleToUser;
import com.ndytar.aglycemie.model.Roles;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static com.ndytar.aglycemie.utils.Constant.API_ROOT;

@RequestMapping(API_ROOT+"/roles")
public interface AccountApi {

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrerment d'un role",notes = "Mehode pour ajout et/ou modification d'un role",response = Roles.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "l'operation bien effectuee "),
            @ApiResponse(code = 400, message = "role inseré n'est pas valide ")
    })
    Roles saveRole(@RequestBody Roles appRole);

    @GetMapping(value = "/all",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Afficher liste roles",notes = "Mehode pour lister les roles",responseContainer = "List<Roles.class>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "roles liste ou liste [  ]")
    })
    List<Roles> finAll();
       @CrossOrigin("*")
    @PostMapping(value = "/AddroleToUser",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Attribuer un role a un user",notes = "Mehode pour attribuer les roles aux utilisateurs",response = RoleToUser.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "l'operation bien effectuee "),
            @ApiResponse(code = 400, message = "Operation non valide ")
    })
   void roleToUser(@RequestBody RoleToUser roleToUser);



}
