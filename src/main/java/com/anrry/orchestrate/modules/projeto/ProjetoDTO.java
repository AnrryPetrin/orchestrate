package com.anrry.orchestrate.modules.projeto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjetoDTO {
  private String nome;
  private String descricao;
  private String dataInicio;
  private String dataFim;
}