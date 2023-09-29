package com.ada.prospect.services;

import com.ada.prospect.models.ProspectPessoaJuridica;
import com.ada.prospect.repositories.ProspectPessoaJuridicaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProspectPessoaJuridicaService {

    private final ProspectPessoaJuridicaRepository prospectPessoaJuridicaRepository;

    public ProspectPessoaJuridicaService(ProspectPessoaJuridicaRepository prospectPessoaJuridicaRepository) {
        this.prospectPessoaJuridicaRepository = prospectPessoaJuridicaRepository;
    }

    public ResponseEntity<String> createPessoaJuridica(ProspectPessoaJuridica prospectPessoaJuridica) {
        try {
            prospectPessoaJuridicaRepository.save(prospectPessoaJuridica);
            Long id = prospectPessoaJuridica.getId();
            return ResponseEntity.ok().body(String.valueOf(id));
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }


    public ResponseEntity<String> updateProspect(Long id, ProspectPessoaJuridica updatedProspect) {
        Optional<ProspectPessoaJuridica> existingRecord = prospectPessoaJuridicaRepository.findById(id);
        if (existingRecord.isPresent()) {
            prospectPessoaJuridicaRepository.findById(id).map(record -> {
                record.setCnpj(updatedProspect.getCnpj());
                record.setEmail(updatedProspect.getEmail());
                record.setCpfContato(updatedProspect.getCpfContato());
                record.setNomeContato(updatedProspect.getNomeContato());
                record.setRazaoSocial(updatedProspect.getRazaoSocial());
                record.setMerchantCategoryCode(updatedProspect.getMerchantCategoryCode());
                ProspectPessoaJuridica updated = prospectPessoaJuridicaRepository.save(record);
                return ResponseEntity.ok().body(updated);
            });
            return ResponseEntity.ok().body("Alteração concluída.");
        } else {
            return ResponseEntity.badRequest().body("ID não encontrado.");
        }
    }

    public ResponseEntity<?> findProspect(Long id) {
        Optional<ProspectPessoaJuridica> existingRecord = prospectPessoaJuridicaRepository.findById(id);
        if (existingRecord.isPresent()) {
            return ResponseEntity.ok().body(prospectPessoaJuridicaRepository.findById(id));
        } else {
            return ResponseEntity.badRequest().body("ID não encontrado");
        }
    }

}



