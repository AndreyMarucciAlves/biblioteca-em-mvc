package com.andrey.projetomvc.controller;

import com.andrey.projetomvc.model.Emprestimo;
import org.springframework.stereotype.Controller;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/emprestimos")
public class EmprestimoController {
    private final List<Emprestimo> emprestimos = new ArrayList<>();

    @GetMapping
    public String listar(Model model){
        model.addAttribute("emprestimos", emprestimos);
        return "emprestimos/lista";
    }

    @GetMapping("/emprestimo")
    public String inicio(Model model){
        model.addAttribute("emprestimo", new Emprestimo());
        return "emprestimos/form";
    }

    @PostMapping("/emprestimo")
    public String cadastrar(@Valid @ModelAttribute Emprestimo emprestimo, BindingResult result){
        if(result.hasErrors()){
            return "emprestimos/form";
        }
        if(emprestimo.getDataDevolucao() == null && emprestimo.getDataEmprestimo() != null){
            emprestimo.setDataDevolucao(emprestimo.getDataEmprestimo().plusDays(5));
        }
        emprestimos.add(emprestimo);
        return "redirect:/emprestimos";
    }

    @GetMapping("/emprestimo/{indice}")
    public String editar(@PathVariable int indice, Model model){
        model.addAttribute("emprestimo", emprestimos.get(indice));
        model.addAttribute("indice", indice);
        return "emprestimos/form";
    }

    @PutMapping("/emprestimo/{indice}")
    public String atualizar(@PathVariable int indice, @Valid @ModelAttribute Emprestimo emprestimo, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("indice", indice);
            return "emprestimos/form";
        }
        emprestimos.set(indice, emprestimo);
        return "redirect:/emprestimos";
    }

    @DeleteMapping("/emprestimo/{indice}")
    public String alterar(@PathVariable int indice){
        if(indice >= 0 && indice < emprestimos.size()){
            emprestimos.remove(indice);
        }
        return "redirect:/emprestimos";
    }
}
