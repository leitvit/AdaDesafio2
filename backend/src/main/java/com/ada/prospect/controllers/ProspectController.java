package com.ada.prospect.controllers;

import com.ada.prospect.models.ProspectPessoaFisica;
import com.ada.prospect.models.ProspectPessoaJuridica;
import com.ada.prospect.services.ProspectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProspectController {

    @Autowired
    private ProspectService prospectService;

    @PostMapping("createprospectpf")
    public ResponseEntity<String> createProspectPessoaFisica(ProspectPessoaFisica prospectPessoaFisica) {
        try{
            String message = prospectService.createPessoaFisica(prospectPessoaFisica);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(message);
        } catch (Exception ex) {
            return ResponseEntity
                    .internalServerError()
                    .body("Erro ao criar Prospect.");
        }
    }

    @PostMapping("createprospectpj")
    public ResponseEntity<String> createProspectPessoaJuridica(ProspectPessoaJuridica prospectPessoaJuridica) {
        try{
            String message = prospectService.createPessoaJuridica(prospectPessoaJuridica);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(message);
        } catch (Exception ex) {
            return ResponseEntity
                    .internalServerError()
                    .body("Erro ao criar Prospect.");
        }
    }

}
