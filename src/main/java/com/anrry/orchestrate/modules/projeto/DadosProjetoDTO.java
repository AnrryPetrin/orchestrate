package com.anrry.orchestrate.modules.projeto;

import com.anrry.orchestrate.modules.funcionario.FuncionarioDTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DadosProjetoDTO {
  private Integer id;
  private String nome;
  private String descricao;
  private List<FuncionarioDTO> funcionarios;
}