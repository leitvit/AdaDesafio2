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
        prospectPessoaFisicaRepository.save(prospectPessoaFisica);
        return "ID: "+ prospectPessoaFisica.getId();
    }

    public String createPessoaJuridica(ProspectPessoaJuridica prospectPessoaJuridica) {
        prospectPessoaJuridicaRepository.save(prospectPessoaJuridica);
        return "ID: "+ prospectPessoaJuridica.getId();
    }
}
