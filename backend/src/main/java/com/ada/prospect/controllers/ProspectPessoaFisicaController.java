package com.ada.prospect.controllers;

import com.ada.prospect.models.ProspectPessoaFisica;
import com.ada.prospect.repositories.ProspectPessoaFisicaRepository;
import com.ada.prospect.services.ProspectPessoaFisicaService;
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
@RequestMapping("/prospectpessoafisica/")
@Tag(name = "Prospect Pessoa Fisica")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso."),
        @ApiResponse(responseCode = "400", description = "Requisição inválida."),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor."),
})
@CrossOrigin(origins = "http://localhost:3000")
public class ProspectPessoaFisicaController {

    private final ProspectPessoaFisicaService prospectPessoaFisicaService;
    private final ProspectPessoaFisicaRepository prospectPessoaFisicaRepository;

    public ProspectPessoaFisicaController(
            ProspectPessoaFisicaService prospectPessoaFisicaService,
            ProspectPessoaFisicaRepository prospectPessoaFisicaRepository
    ) {
        this.prospectPessoaFisicaService = prospectPessoaFisicaService;
        this.prospectPessoaFisicaRepository = prospectPessoaFisicaRepository;
    }

    @PostMapping(value = "createprospect", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Cria uma nova entrada de cliente Pessoa Física.")
    @Validated
    public ResponseEntity<String> createProspect(@RequestBody ProspectPessoaFisica prospectPessoaFisica) {
        return prospectPessoaFisicaService.create(prospectPessoaFisica);
    }

    @GetMapping(value = "entities/findall", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Busca e retorna todos os clientes PF cadastrados, se existirem.")
    @Validated
    public List<ProspectPessoaFisica> findAll() {
        return prospectPessoaFisicaRepository.findAll();
    }


    @GetMapping(value = "entities/findbyid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Busca e retorna o cliente cadastrado, se existir, através do id informado.")
    @Validated
    public ResponseEntity<?> findProspectById(@PathVariable("id") Long id) {
        return prospectPessoaFisicaService.findById(id);
    }

    @Operation(summary = "Altera um Prospect PF")
    @PutMapping(value = "entities/updatebyid/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Validated
    public ResponseEntity<String> updateProspect(
            @PathVariable Long id,
            @Valid @RequestBody ProspectPessoaFisica prospectPessoaFisica) {
        return prospectPessoaFisicaService.update(id, prospectPessoaFisica);
    }
}