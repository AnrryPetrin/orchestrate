package com.anrry.orchestrate.modules.projeto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anrry.orchestrate.modules.funcionario.Funcionario;
import com.anrry.orchestrate.modules.funcionario.FuncionarioDTO;
import com.anrry.orchestrate.modules.funcionario.FuncionarioRepository;

@Service
public class ProjetoService {
  @Autowired
  private ProjetoRepository projetoRepository;
  @Autowired
  private FuncionarioRepository funcionarioRepository;

  public void adicionar(ProjetoDTO projetoDTO) {
    Projeto projeto = new Projeto();
    projeto.setNome(projetoDTO.getNome());
    projeto.setDescricao(projetoDTO.getDescricao());
    projeto.setDataInicio(projetoDTO.getDataInicio());
    projeto.setDataFim(projetoDTO.getDataFim());
    projetoRepository.save(projeto);
  }

  public DadosProjetoDTO buscarProjetoPorId(Integer id) {
    Projeto projeto = projetoRepository.findByIdWithFuncionarios(id);
    List<FuncionarioDTO> funcionarios = projeto.getFuncionarios().stream()
        .map(funcionario -> new FuncionarioDTO(funcionario.getNome(), funcionario.getProjeto().getId(),
            funcionario.getSetor() != null ? funcionario.getSetor().getId() : null))
        .collect(Collectors.toList());
    return new DadosProjetoDTO(projeto.getId(), projeto.getNome(), projeto.getDescricao(), funcionarios);
  }

  public void vincularFuncionario(Integer idProjeto, Integer idFuncionario) {
    Projeto projeto = projetoRepository.findById(idProjeto)
        .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));
    Funcionario funcionario = funcionarioRepository.findById(idFuncionario)
        .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));
    funcionario.setProjeto(projeto);
    funcionarioRepository.save(funcionario);
  }
}