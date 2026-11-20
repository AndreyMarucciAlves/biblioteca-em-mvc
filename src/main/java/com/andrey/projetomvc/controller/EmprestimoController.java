package com.andrey.projetomvc.controller;

import com.andrey.projetomvc.model.Emprestimo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/emprestimos")
public class EmprestimoController {
    private final List<Emprestimo> emprestimos = new ArrayList<>();

    @GetMapping("/empresitmo")
    public String inicio(){
        return "emprestimos/inicio";
    }


    @PostMapping("/emprestimo")
    public String cadastrar(@ModelAttribute Emprestimo emprestimo){
        emprestimos.add(emprestimo);
        return "redirect:/livros";
    }

    @DeleteMapping("/empresitmo/{indice}")
    public String alterar(@PathVariable int indice){
        if(indice >= 0 && indice < emprestimos.size()){
            emprestimos.remove(indice);
        }
        return "redirect:/emprestimos";
    }
}
