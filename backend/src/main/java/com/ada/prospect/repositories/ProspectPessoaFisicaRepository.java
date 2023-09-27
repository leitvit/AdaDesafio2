package com.ada.prospect.repositories;

import com.ada.prospect.models.ProspectPessoaFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProspectPessoaFisicaRepository  extends JpaRepository<ProspectPessoaFisica, Long> {
}
