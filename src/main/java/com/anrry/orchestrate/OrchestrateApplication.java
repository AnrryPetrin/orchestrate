package com.anrry.orchestrate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.anrry.orchestrate.modules.funcionario.FuncionarioDTO;
import com.anrry.orchestrate.modules.funcionario.FuncionarioService;
import com.anrry.orchestrate.modules.projeto.ProjetoDTO;
import com.anrry.orchestrate.modules.projeto.ProjetoService;
import com.anrry.orchestrate.modules.setor.SetorDTO;
import com.anrry.orchestrate.modules.setor.SetorService;

@SpringBootApplication
public class OrchestrateApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrchestrateApplication.class, args);

        // Create instances and relationships for testing
        ProjetoService projetoService = context.getBean(ProjetoService.class);
        FuncionarioService funcionarioService = context.getBean(FuncionarioService.class);
        SetorService setorService = context.getBean(SetorService.class);

        // Adding Setores
        SetorDTO setorDTO1 = new SetorDTO("Setor de Tecnologia");
        SetorDTO setorDTO2 = new SetorDTO("Setor de Marketing");
        setorService.adicionar(setorDTO1);
        setorService.adicionar(setorDTO2);

        // Adding Projetos
        ProjetoDTO projetoDTO1 = new ProjetoDTO("Projeto Alpha", "Descrição do Projeto Alpha", "2024-10-01",
                "2024-12-31");
        ProjetoDTO projetoDTO2 = new ProjetoDTO("Projeto Beta", "Descrição do Projeto Beta", "2024-11-01",
                "2025-01-31");
        projetoService.adicionar(projetoDTO1);
        projetoService.adicionar(projetoDTO2);

        // Adding Funcionarios and associating them with Setor and Projeto
        FuncionarioDTO funcionarioDTO1 = new FuncionarioDTO("Carlos Silva", 1, 1);
        FuncionarioDTO funcionarioDTO2 = new FuncionarioDTO("Ana Pereira", 2, 2);
        funcionarioService.adicionar(funcionarioDTO1);
        funcionarioService.adicionar(funcionarioDTO2);
    }
}
