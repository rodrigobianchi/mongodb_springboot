package io.github.bianchi.controller;

import io.github.bianchi.model.Funcionario;
import io.github.bianchi.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List<Funcionario> obterTodos() {
        return funcionarioService.obterTodos();
    }

    @GetMapping("/{codigo}")
    public Funcionario obterPorCodigo(@PathVariable String codigo) {
        return funcionarioService.obterPorCodigo(codigo);
    }

    @PostMapping
    public Funcionario criar(@RequestBody Funcionario funcionario) {
        return funcionarioService.criar(funcionario);
    }

    @GetMapping("/range")
    public List<Funcionario> obterFuncionariosPorRangeDeIdade(
            @RequestParam("de") Integer de,
            @RequestParam("ate") Integer ate) {
        return funcionarioService.obterFuncionariosPorRangeDeIdade(de, ate);
    }
}
