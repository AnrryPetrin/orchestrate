package com.anrry.orchestrate.modules.funcionario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioDTO {
  private String nome;
  private Integer projetoId;
  private Integer setorId;
}