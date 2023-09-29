package com.ada.prospect.controllers;

import com.ada.prospect.models.ProspectPessoaJuridica;
import com.ada.prospect.repositories.ProspectPessoaJuridicaRepository;
import com.ada.prospect.services.ProspectPessoaJuridicaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prospectpessoajuridica/")
@Tag(name = "Prospect Pessoa Juridica")
public class ProspectPessoaJuridicaController {

    private final ProspectPessoaJuridicaService prospectPessoaJuridicaService;
    private final ProspectPessoaJuridicaRepository prospectPessoaJuridicaRepository;

    public ProspectPessoaJuridicaController(
            ProspectPessoaJuridicaService prospectPessoaJuridicaService,
            ProspectPessoaJuridicaRepository prospectPessoaJuridicaRepository
    ) {
        this.prospectPessoaJuridicaService = prospectPessoaJuridicaService;
        this.prospectPessoaJuridicaRepository = prospectPessoaJuridicaRepository;
    }

    @PostMapping(value = "createprospect", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Cria uma nova entrada de cliente Pessoa Jurídica.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente criado com sucesso.")
    })
    @Validated
    public ResponseEntity<String> createProspect(@RequestBody ProspectPessoaJuridica prospectPessoaJuridica) {
        return prospectPessoaJuridicaService.createPessoaJuridica(prospectPessoaJuridica);
    }

    @GetMapping(value = "entities/findall", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Busca e retorna todos os clientes PJ cadastrados, se existirem.")
    @Validated
    public List<ProspectPessoaJuridica> findAll() {
        return prospectPessoaJuridicaRepository.findAll();
    }

    @GetMapping(value = "entities/findbyid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Busca e retorna o cliente cadastrado, se existir, através do id informado.")
    @Validated
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente criado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Requisição inválida."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor."),
    })
    public ResponseEntity<?> findProspectById(@PathVariable("id") Long id) {
        return prospectPessoaJuridicaService.findProspect(id);
    }

    @Operation(summary = "Altera um Prospect PJ")
    @PutMapping(value = "entities/updatebyid/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Validated
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente criado com sucesso."),
            @ApiResponse(responseCode = "400", description = "Requisição inválida."),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor."),
    })
    public ResponseEntity<String> updateProspect(
            @PathVariable Long id,
            @Valid @RequestBody ProspectPessoaJuridica prospectPessoaJuridica) {
        return prospectPessoaJuridicaService.updateProspect(id, prospectPessoaJuridica);
    }
}