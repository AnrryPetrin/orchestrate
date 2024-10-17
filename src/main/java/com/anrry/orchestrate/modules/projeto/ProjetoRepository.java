package com.anrry.orchestrate.modules.projeto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Integer> {
  List<Projeto> findAllByDataInicioBetween(String dataInicio, String dataFim);

  Projeto findByIdAndFetchFuncionarios(Integer id);
}