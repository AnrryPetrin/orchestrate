package com.anrry.orchestrate.modules.setor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anrry.orchestrate.modules.funcionario.FuncionarioDTO;

@Service
public class SetorService {
  @Autowired
  private SetorRepository setorRepository;

  public void adicionar(SetorDTO setorDTO) {
    Setor setor = new Setor();
    setor.setNome(setorDTO.getNome());
    setorRepository.save(setor);
  }

  public DadosSetorDTO buscarSetorPorId(Integer idSetor) {
    Setor setor = setorRepository.findById(idSetor).orElseThrow(() -> new RuntimeException("Setor não encontrado"));
    List<FuncionarioDTO> funcionarios = setor.getFuncionarios().stream()
        .map(funcionario -> new FuncionarioDTO(funcionario.getNome(),
            funcionario.getProjeto() != null ? funcionario.getProjeto().getId() : null))
        .collect(Collectors.toList());
    return new DadosSetorDTO(setor.getId(), setor.getNome(), funcionarios);
  }
}