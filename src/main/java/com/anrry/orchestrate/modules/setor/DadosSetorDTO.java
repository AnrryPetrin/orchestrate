package com.anrry.orchestrate.modules.setor;

import java.util.List;

import com.anrry.orchestrate.modules.funcionario.FuncionarioDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DadosSetorDTO {
  private Integer id;
  private String nome;
  private List<FuncionarioDTO> funcionarios;
}