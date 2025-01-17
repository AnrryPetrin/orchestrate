package com.anrry.orchestrate.modules.funcionario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {
  List<Funcionario> findAllByProjetoId(Integer projetoId);
}