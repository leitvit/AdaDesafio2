package com.ada.prospect.services;

import com.ada.prospect.models.ProspectPessoaFisica;
import com.ada.prospect.models.ProspectPessoaJuridica;
import com.ada.prospect.repositories.ProspectPessoaFisicaRepository;
import com.ada.prospect.repositories.ProspectPessoaJuridicaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProspectService {

    final ProspectPessoaJuridicaRepository prospectPessoaJuridicaRepository;

    final ProspectPessoaFisicaRepository prospectPessoaFisicaRepository;

    public ProspectService(ProspectPessoaFisicaRepository prospectPessoaFisicaRepository, ProspectPessoaJuridicaRepository prospectPessoaJuridicaRepository) {
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
}
