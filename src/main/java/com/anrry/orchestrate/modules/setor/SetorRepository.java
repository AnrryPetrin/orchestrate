package com.anrry.orchestrate.modules.setor;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Integer> {
  List<Setor> findAllWithFuncionarios();
}
