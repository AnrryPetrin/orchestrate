package com.anrry.orchestrate.modules.projeto;

import java.util.List;

import com.anrry.orchestrate.modules.funcionario.Funcionario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Projeto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String nome;
  private String descricao;
  private String dataInicio;
  private String dataFim;

  @OneToMany(mappedBy = "projeto")
  private List<Funcionario> funcionarios;
}