package com.anrry.orchestrate.modules.setor;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SetorRepository extends JpaRepository<Setor, Integer> {
  @Query("SELECT s FROM Setor s LEFT JOIN FETCH s.funcionarios")
  List<Setor> findAllWithFuncionarios();
}
