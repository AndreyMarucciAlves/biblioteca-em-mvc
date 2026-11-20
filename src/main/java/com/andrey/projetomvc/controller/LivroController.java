package com.andrey.projetomvc.controller;

import com.andrey.projetomvc.model.Livro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/livros")
public class LivroController {

    private final List<Livro> livros = new ArrayList<>();

    @GetMapping
    public String inicio(){ return "livros/inicio"; }

    @GetMapping("/livro")
    public String exibirLivro(Model model){
        Livro livro = new Livro();
        livro.setTitutlo("Dom Casmurro");
        livro.setAutor("Machado de Assis");
        livro.setIsbn("978-85-00-00000-0");

        model.addAttribute("livro", livro);

        return "livro";
    }

    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("livros", livros);
        return "livros/listar";
    }

    @PostMapping("/livro")
    public String cadastrar(@ModelAttribute Livro livro){
        livros.add(livro);
        return "redirect:/livros";
    }

    @DeleteMapping("/livro/{indice}")
    public String alterar(@PathVariable int indice){
        if(indice >= 0 && indice < livros.size()){
            livros.remove(indice);
        }
        return "redirect:/livros";
    }
}
