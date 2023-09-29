package com.ada.prospect.services;

import com.ada.prospect.models.ProspectPessoaJuridica;
import com.ada.prospect.repositories.ProspectPessoaJuridicaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProspectPessoaJuridicaService {

    private final ProspectPessoaJuridicaRepository prospectRepository;
    private final QueueService queueService;

    public ProspectPessoaJuridicaService(ProspectPessoaJuridicaRepository prospectRepository, QueueService queueService) {
        this.prospectRepository = prospectRepository;
        this.queueService = queueService;
    }

    public ResponseEntity<String> create(ProspectPessoaJuridica prospectPessoaJuridica) {
        try {
            prospectRepository.save(prospectPessoaJuridica);
            Long id = prospectPessoaJuridica.getId();
            queueService.addQueueItem(prospectPessoaJuridica);
            return ResponseEntity.ok().body(String.valueOf(id));
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    public ResponseEntity<String> update(Long id, ProspectPessoaJuridica prospectUpdate) {
        Optional<ProspectPessoaJuridica> existingRecord = prospectRepository.findById(id);
        if (existingRecord.isPresent()) {
            ProspectPessoaJuridica updatedProspect= prospectRepository.findById(id).map(record -> {
                record.setCnpj(prospectUpdate.getCnpj());
                record.setEmail(prospectUpdate.getEmail());
                record.setCpfContato(prospectUpdate.getCpfContato());
                record.setNomeContato(prospectUpdate.getNomeContato());
                record.setRazaoSocial(prospectUpdate.getRazaoSocial());
                record.setMerchantCategoryCode(prospectUpdate.getMerchantCategoryCode());
                return prospectRepository.save(record);
            }).orElse(null);
            // Add to queue
            queueService.addQueueItem(updatedProspect);

            return ResponseEntity.ok().body("Alteração concluída.");
        } else {
            return ResponseEntity.badRequest().body("ID não encontrado.");
        }
    }

    public ResponseEntity<?> findById(Long id) {
        Optional<ProspectPessoaJuridica> existingRecord = prospectRepository.findById(id);
        if (existingRecord.isPresent()) {
            return ResponseEntity.ok().body(prospectRepository.findById(id));
        } else {
            return ResponseEntity.badRequest().body("ID não encontrado");
        }
    }

}



