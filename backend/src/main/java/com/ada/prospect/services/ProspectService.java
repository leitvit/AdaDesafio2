package com.ada.prospect.services;

import com.ada.prospect.models.ProspectPessoaFisica;
import com.ada.prospect.models.ProspectPessoaJuridica;
import com.ada.prospect.repositories.ProspectPessoaFisicaRepository;
import com.ada.prospect.repositories.ProspectPessoaJuridicaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProspectService {

    private final ProspectPessoaJuridicaRepository prospectPessoaJuridicaRepository;

    private final ProspectPessoaFisicaRepository prospectPessoaFisicaRepository;

    public ProspectService(
            ProspectPessoaFisicaRepository prospectPessoaFisicaRepository,
            ProspectPessoaJuridicaRepository prospectPessoaJuridicaRepository) {
        this.prospectPessoaFisicaRepository = prospectPessoaFisicaRepository;
        this.prospectPessoaJuridicaRepository = prospectPessoaJuridicaRepository;
    }


    public String createPessoaFisica(ProspectPessoaFisica prospectPessoaFisica) {
        try {
            prospectPessoaFisicaRepository.save(prospectPessoaFisica);
            return String.valueOf(prospectPessoaFisica.getId());
        } catch (Exception exception) {
            return exception.getMessage();
        }
    }

    public String createPessoaJuridica(ProspectPessoaJuridica prospectPessoaJuridica) {
        try {
            prospectPessoaJuridicaRepository.save(prospectPessoaJuridica);
            return String.valueOf(prospectPessoaJuridica.getId());
        } catch (Exception exception) {
            return exception.getMessage();
        }
    }


    public String updatePessoaJuridica(Long id, ProspectPessoaJuridica prospect) {
        prospectPessoaJuridicaRepository.findById(id)
                .map(record -> {
                    record.setCnpj(prospect.getCnpj());
                    record.setEmail(prospect.getEmail());
                    record.setCpfContato(prospect.getCpfContato());
                    record.setNomeContato(prospect.getNomeContato());
                    record.setRazaoSocial(prospect.getRazaoSocial());
                    record.setMerchantCategoryCode(prospect.getMerchantCategoryCode());
                    ProspectPessoaJuridica updated = prospectPessoaJuridicaRepository.save(record);
                    return ResponseEntity.ok().body(updated);
                });
        return "Alteração concluída.";
    }

    public String updatePessoaFisica(Long id, ProspectPessoaFisica prospect) {
        prospectPessoaFisicaRepository.findById(id)
                .map(record -> {
                    record.setCpf(prospect.getCpf());
                    record.setEmail(prospect.getEmail());
                    record.setMerchantCategoryCode(prospect.getMerchantCategoryCode());
                    record.setNome(prospect.getNome());
                    ProspectPessoaFisica updated = prospectPessoaFisicaRepository.save(record);
                    return ResponseEntity.ok().body(updated);
                });
        return "Alteração concluída.";
    }
}

