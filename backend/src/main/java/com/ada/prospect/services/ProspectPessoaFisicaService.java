package com.ada.prospect.services;

import com.ada.prospect.models.ProspectPessoaFisica;
import com.ada.prospect.repositories.ProspectPessoaFisicaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProspectPessoaFisicaService {

    private final ProspectPessoaFisicaRepository prospectRepository;
    private final QueueService queueService;

    public ProspectPessoaFisicaService(ProspectPessoaFisicaRepository prospectRepository, QueueService queueService) {
        this.prospectRepository = prospectRepository;
        this.queueService = queueService;
    }


    public ResponseEntity<String> create(ProspectPessoaFisica prospectPessoaFisica) {
        try {
            prospectRepository.save(prospectPessoaFisica);
            Long id = prospectPessoaFisica.getId();
            queueService.addQueueItem(prospectPessoaFisica);
            return ResponseEntity.ok().body(String.valueOf(id));
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    public ResponseEntity<String> update(Long id, ProspectPessoaFisica prospectUpdate) {
        Optional<ProspectPessoaFisica> existingRecord = prospectRepository.findById(id);
        if (existingRecord.isPresent()) {
            ProspectPessoaFisica updatedProspect = existingRecord.map(record -> {
                record.setCpf(prospectUpdate.getCpf());
                record.setEmail(prospectUpdate.getEmail());
                record.setMerchantCategoryCode(prospectUpdate.getMerchantCategoryCode());
                record.setNome(prospectUpdate.getNome());
                return prospectRepository.save(record);
            }).orElse(null);
            queueService.addQueueItem(updatedProspect);

            return ResponseEntity.ok().body("Alteração concluída.");
        } else {
            return ResponseEntity.badRequest().body("ID não encontrado.");
        }
    }

    public ResponseEntity<?> findById(Long id) {
        Optional<ProspectPessoaFisica> existingRecord = prospectRepository.findById(id);
        if (existingRecord.isPresent()) {
            return ResponseEntity.ok().body(prospectRepository.findById(id));
        } else {
            return ResponseEntity.badRequest().body("ID não encontrado");
        }
    }
}



