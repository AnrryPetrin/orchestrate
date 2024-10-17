package com.anrry.orchestrate.modules.funcionario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anrry.orchestrate.modules.projeto.DadosProjetoDTO;
import com.anrry.orchestrate.modules.projeto.Projeto;
import com.anrry.orchestrate.modules.projeto.ProjetoRepository;

@Service
public class FuncionarioService {
  @Autowired
  private FuncionarioRepository funcionarioRepository;
  @Autowired
  private ProjetoRepository projetoRepository;

  public void adicionar(FuncionarioDTO funcionarioDTO) {
    Funcionario funcionario = new Funcionario();
    funcionario.setNome(funcionarioDTO.getNome());
    if (funcionarioDTO.getProjetoId() != null) {
      Projeto projeto = projetoRepository.findById(funcionarioDTO.getProjetoId()).orElse(null);
      funcionario.setProjeto(projeto);
    }
    funcionarioRepository.save(funcionario);
  }

  public List<DadosProjetoDTO> buscarProjetos(Integer idFuncionario) {
    Funcionario funcionario = funcionarioRepository.findById(idFuncionario)
        .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));
    Projeto projeto = funcionario.getProjeto();
    if (projeto != null) {
      List<FuncionarioDTO> funcionarios = projeto.getFuncionarios().stream()
          .map(f -> new FuncionarioDTO(f.getNome(), f.getProjeto().getId()))
          .collect(Collectors.toList());
      return List.of(new DadosProjetoDTO(projeto.getId(), projeto.getNome(), projeto.getDescricao(), funcionarios));
    }
    return List.of();
  }
}