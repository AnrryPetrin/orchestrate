package com.anrry.orchestrate.modules.setor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/setores")
public class SetorController {
  private final SetorService setorService;

  public SetorController(SetorService setorService) {
    this.setorService = setorService;
  }

  @PostMapping("/adicionar")
  public void adicionar(@RequestBody SetorDTO setorDTO) {
    setorService.adicionar(setorDTO);
  }

  @GetMapping("/{idSetor}")
  public DadosSetorDTO buscarSetorPorId(@PathVariable Integer idSetor) {
    return setorService.buscarSetorPorId(idSetor);
  }
}