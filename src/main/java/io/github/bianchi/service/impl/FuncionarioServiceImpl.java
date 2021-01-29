package io.github.bianchi.service.impl;

import io.github.bianchi.model.Funcionario;
import io.github.bianchi.repository.FuncionarioRepository;
import io.github.bianchi.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public List<Funcionario> obterTodos() {
        return funcionarioRepository.findAll();
    }

    @Override
    public Funcionario obterPorCodigo(String codigo) {
        return funcionarioRepository.findById(codigo)
                .orElseThrow(() -> new IllegalArgumentException("Funcionário inexistente"));
    }

    @Override
    public Funcionario criar(Funcionario funcionario) {
        Funcionario gestor = obterPorCodigo(funcionario.getGestor().getCodigo());
        funcionario.setGestor(gestor);
        return funcionarioRepository.save(funcionario);
    }

    @Override
    public List<Funcionario> obterFuncionariosPorRangeDeIdade(Integer de, Integer ate) {
        return funcionarioRepository.obterFuncionariosPorRangeDeIdade(de, ate);
    }
}
