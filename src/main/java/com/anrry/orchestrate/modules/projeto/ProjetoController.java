package com.anrry.orchestrate.modules.projeto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {
  private final ProjetoService projetoService;

  public ProjetoController(ProjetoService projetoService) {
    this.projetoService = projetoService;
  }

  @PostMapping("/adicionar")
  public void adicionar(@RequestBody ProjetoDTO projetoDTO) {
    projetoService.adicionar(projetoDTO);
  }

  @GetMapping("/{id}")
  public DadosProjetoDTO buscarProjetoPorId(@PathVariable Integer id) {
    return projetoService.buscarProjetoPorId(id);
  }

  @PostMapping("/{idProjeto}/vincularFuncionario/{idFuncionario}")
  public void vincularFuncionario(@PathVariable Integer idProjeto, @PathVariable Integer idFuncionario) {
    projetoService.vincularFuncionario(idProjeto, idFuncionario);
  }
}
