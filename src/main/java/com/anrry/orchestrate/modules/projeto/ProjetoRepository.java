package com.anrry.orchestrate.modules.projeto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Integer> {
  List<Projeto> findAllByDataInicioBetween(String dataInicio, String dataFim);

  @Query("SELECT p FROM Projeto p LEFT JOIN FETCH p.funcionarios WHERE p.id = :id")
  Projeto findByIdWithFuncionarios(Integer id);
}