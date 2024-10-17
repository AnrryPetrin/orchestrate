package com.anrry.orchestrate.modules.funcionario;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anrry.orchestrate.modules.projeto.DadosProjetoDTO;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
  private final FuncionarioService funcionarioService;

  public FuncionarioController(FuncionarioService funcionarioService) {
    this.funcionarioService = funcionarioService;
  }

  @PostMapping("/adicionar")
  public void adicionar(@RequestBody FuncionarioDTO funcionarioDTO) {
    funcionarioService.adicionar(funcionarioDTO);
  }

  @GetMapping("/{idFuncionario}/projetos")
  public List<DadosProjetoDTO> buscarProjetos(@PathVariable Integer idFuncionario) {
    return funcionarioService.buscarProjetos(idFuncionario);
  }
}