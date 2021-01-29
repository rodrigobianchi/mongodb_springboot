package io.github.bianchi.service;

import io.github.bianchi.model.Funcionario;

import java.util.List;

public interface FuncionarioService {

    public List<Funcionario> obterTodos();

    public Funcionario obterPorCodigo(String codigo);

    public Funcionario criar(Funcionario funcionario);

    public List<Funcionario> obterFuncionariosPorRangeDeIdade(Integer de, Integer ate);
}
