package com.ada.prospect.services;

import com.ada.prospect.models.ProspectPessoaFisica;
import com.ada.prospect.repositories.ProspectPessoaFisicaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProspectPessoaFisicaService {

    private final ProspectPessoaFisicaRepository prospectPessoaFisicaRepository;

    public ProspectPessoaFisicaService(ProspectPessoaFisicaRepository prospectPessoaFisicaRepository) {
        this.prospectPessoaFisicaRepository = prospectPessoaFisicaRepository;
    }


    public ResponseEntity<String> create(ProspectPessoaFisica prospectPessoaFisica) {
        try {
            prospectPessoaFisicaRepository.save(prospectPessoaFisica);
            Long id = prospectPessoaFisica.getId();
            return ResponseEntity.ok().body(String.valueOf(id));
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    public ResponseEntity<String> updateProspect(Long id, ProspectPessoaFisica prospect) {
        Optional<ProspectPessoaFisica> existingRecord = prospectPessoaFisicaRepository.findById(id);
        if (existingRecord.isPresent()) {
            prospectPessoaFisicaRepository.findById(id).map(record -> {
                record.setCpf(prospect.getCpf());
                record.setEmail(prospect.getEmail());
                record.setMerchantCategoryCode(prospect.getMerchantCategoryCode());
                record.setNome(prospect.getNome());
                ProspectPessoaFisica updated = prospectPessoaFisicaRepository.save(record);
                return ResponseEntity.ok().body(updated);
            });
            return ResponseEntity.ok().body("Alteração concluída.");
        } else {
            return ResponseEntity.badRequest().body("ID não encontrado.");
        }
    }

    public ResponseEntity<?> findById(Long id) {
        Optional<ProspectPessoaFisica> existingRecord = prospectPessoaFisicaRepository.findById(id);
        if (existingRecord.isPresent()) {
            return ResponseEntity.ok().body(prospectPessoaFisicaRepository.findById(id));
        } else {
            return ResponseEntity.badRequest().body("ID não encontrado");
        }
    }
}



