package com.anrry.orchestrate.modules.funcionario;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anrry.orchestrate.modules.projeto.DadosProjetoDTO;
import com.anrry.orchestrate.modules.projeto.Projeto;
import com.anrry.orchestrate.modules.projeto.ProjetoRepository;
import com.anrry.orchestrate.modules.setor.DadosSetorDTO;
import com.anrry.orchestrate.modules.setor.Setor;
import com.anrry.orchestrate.modules.setor.SetorRepository;

@Service
public class FuncionarioService {
  @Autowired
  private FuncionarioRepository funcionarioRepository;
  @Autowired
  private ProjetoRepository projetoRepository;
  @Autowired
  private SetorRepository setorRepository;

  public void adicionar(FuncionarioDTO funcionarioDTO) {
    Funcionario funcionario = new Funcionario();
    funcionario.setNome(funcionarioDTO.getNome());
    if (funcionarioDTO.getProjetoId() != null) {
      Projeto projeto = projetoRepository.findById(funcionarioDTO.getProjetoId()).orElse(null);
      funcionario.setProjeto(projeto);
    }
    if (funcionarioDTO.getSetorId() != null) {
      Setor setor = setorRepository.findById(funcionarioDTO.getSetorId()).orElse(null);
      funcionario.setSetor(setor);
    }
    funcionarioRepository.save(funcionario);
  }

  public FuncionarioDTO buscarFuncionarioPorId(Integer id) {
    Funcionario funcionario = funcionarioRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));
    return new FuncionarioDTO(funcionario.getNome(),
        funcionario.getProjeto() != null ? funcionario.getProjeto().getId() : null,
        funcionario.getSetor() != null ? funcionario.getSetor().getId() : null);
  }

  public List<DadosProjetoDTO> buscarProjetos(Integer idFuncionario) {
    Funcionario funcionario = funcionarioRepository.findById(idFuncionario)
        .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));
    Projeto projeto = funcionario.getProjeto();
    if (projeto != null) {
      List<FuncionarioDTO> funcionarios = projeto.getFuncionarios().stream()
          .map(f -> new FuncionarioDTO(f.getNome(), f.getProjeto().getId(),
              f.getSetor() != null ? f.getSetor().getId() : null))
          .collect(Collectors.toList());
      return List.of(new DadosProjetoDTO(projeto.getId(), projeto.getNome(), projeto.getDescricao(), funcionarios));
    }
    return List.of();
  }

  public DadosSetorDTO buscarSetor(Integer idFuncionario) {
    Funcionario funcionario = funcionarioRepository.findById(idFuncionario)
        .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));
    Setor setor = funcionario.getSetor();
    if (setor != null) {
      List<FuncionarioDTO> funcionarios = setor.getFuncionarios().stream()
          .map(f -> new FuncionarioDTO(f.getNome(), f.getProjeto() != null ? f.getProjeto().getId() : null,
              f.getSetor().getId()))
          .collect(Collectors.toList());
      return new DadosSetorDTO(setor.getId(), setor.getNome(), funcionarios);
    }
    return null;
  }
}