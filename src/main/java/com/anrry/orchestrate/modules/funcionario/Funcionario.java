package com.anrry.orchestrate.modules.funcionario;

import com.anrry.orchestrate.modules.projeto.Projeto;
import com.anrry.orchestrate.modules.setor.Setor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String nome;

  @ManyToOne
  @JoinColumn(name = "projeto_id")
  private Projeto projeto;

  @ManyToOne
  @JoinColumn(name = "setor_id")
  private Setor setor;
}