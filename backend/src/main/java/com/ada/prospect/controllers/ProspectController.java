package com.ada.prospect.controllers;

import com.ada.prospect.models.ProspectPessoaFisica;
import com.ada.prospect.models.ProspectPessoaJuridica;
import com.ada.prospect.repositories.ProspectPessoaFisicaRepository;
import com.ada.prospect.repositories.ProspectPessoaJuridicaRepository;
import com.ada.prospect.services.ProspectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/prospect/")
@Tag(name = "Prospect")
public class ProspectController {

    private final ProspectService prospectService;
    private final ProspectPessoaFisicaRepository prospectPessoaFisicaRepository;
    private final ProspectPessoaJuridicaRepository prospectPessoaJuridicaRepository;

    public ProspectController(
            ProspectService prospectService,
            ProspectPessoaFisicaRepository prospectPessoaFisicaRepository,
            ProspectPessoaJuridicaRepository prospectPessoaJuridicaRepository
    ) {
        this.prospectService = prospectService;
        this.prospectPessoaFisicaRepository = prospectPessoaFisicaRepository;
        this.prospectPessoaJuridicaRepository = prospectPessoaJuridicaRepository;
    }

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

    @GetMapping(value = "entities/prospectpf/findall", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Busca e retorna o cliente cadastrado, se existir, através do id informado.")
    public List<ProspectPessoaFisica> findAllProspectPessoaFisica() {
        return prospectPessoaFisicaRepository.findAll();
    }

    @GetMapping(value = "entities/prospectpj/findall", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Busca e retorna o cliente cadastrado, se existir, através do id informado.")
    public List<ProspectPessoaJuridica> findAllProspectPessoaJuridica() {
        return prospectPessoaJuridicaRepository.findAll();
    }

    @GetMapping(value = "entities/prospectpf/findbyid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Busca e retorna o cliente cadastrado, se existir, através do id informado.")
    public Optional<ProspectPessoaFisica> findProspectPessoaFisicaById(@PathVariable("id") Long id) {
        return prospectPessoaFisicaRepository.findById(id);
    }

    @GetMapping(value = "entities/prospectpj/findbyid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Busca e retorna o cliente cadastrado, se existir, através do id informado.")
    public Optional<ProspectPessoaJuridica> findProspectPessoaJuridicaById(@PathVariable("id") Long id) {
        return prospectPessoaJuridicaRepository.findById(id);
    }

    @Operation(summary = "Altera um Prospect PJ")
    @PutMapping(value = "entities/prospectpj/updatebyid/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateProspectPessoaJuridicaById(
            @PathVariable Long id, @RequestBody ProspectPessoaJuridica prospectPessoaJuridica) {
        return ResponseEntity.ok(prospectService.updatePessoaJuridica(id, prospectPessoaJuridica));
    }

    @Operation(summary = "Altera um Prospect PF")
    @PutMapping(value = "entities/prospectpf/updatebyid/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateProspectPessoaFisicaById(
            @PathVariable Long id, @RequestBody ProspectPessoaFisica prospectPessoaFisica) {
        return ResponseEntity.ok(prospectService.updatePessoaFisica(id, prospectPessoaFisica));
    }
}