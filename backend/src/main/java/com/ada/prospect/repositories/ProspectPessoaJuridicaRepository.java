package com.ada.prospect.repositories;

import com.ada.prospect.models.ProspectPessoaJuridica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProspectPessoaJuridicaRepository extends JpaRepository<ProspectPessoaJuridica, Long> {
}
