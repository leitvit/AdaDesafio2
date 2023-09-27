package com.ada.prospect.controllers;

import com.ada.prospect.models.ProspectPessoaFisica;
import com.ada.prospect.models.ProspectPessoaJuridica;
import com.ada.prospect.services.ProspectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/prospect/")
@Tag(name = "Prospect")
public class ProspectController {

    @Autowired
    private ProspectService prospectService;

    @PostMapping(value = "createprospectpf", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Cria uma nova entrada de cliente Pessoa Física.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente criado com sucesso.")
    })
    public ResponseEntity<String> createProspectPessoaFisica(@RequestBody ProspectPessoaFisica prospectPessoaFisica) {
        String responseMessage = prospectService.createPessoaFisica(prospectPessoaFisica);
        return ResponseEntity.ok().body(responseMessage);
    }

    @PostMapping(value = "createprospectpj", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Cria uma nova entrada de cliente Pessoa Jurídica.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente criado com sucesso.")
    })
    public ResponseEntity<String> createProspectPessoaJuridica(@RequestBody ProspectPessoaJuridica prospectPessoaJuridica) {
        String responseMessage = prospectService.createPessoaJuridica(prospectPessoaJuridica);
        return ResponseEntity.ok().body(responseMessage);
    }
}
