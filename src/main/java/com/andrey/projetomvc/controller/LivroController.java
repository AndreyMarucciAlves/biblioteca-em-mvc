package com.andrey.projetomvc.controller;

import com.andrey.projetomvc.model.Livro;
import org.springframework.stereotype.Controller;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

    @GetMapping("/novo")
    public String novo(Model model){
        model.addAttribute("livro", new Livro());
        return "livros/form";
    }

    @PostMapping("/livro")
    public String cadastrar(@Valid @ModelAttribute Livro livro, BindingResult result){
        if(result.hasErrors()){
            return "livros/form";
        }
        livros.add(livro);
        return "redirect:/livros/listar";
    }

    @GetMapping("/livro/{indice}")
    public String editar(@PathVariable int indice, Model model){
        model.addAttribute("livro", livros.get(indice));
        model.addAttribute("indice", indice);
        return "livros/form";
    }

    @PutMapping("/livro/{indice}")
    public String atualizar(@PathVariable int indice, @Valid @ModelAttribute Livro livro, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("indice", indice);
            return "livros/form";
        }
        livros.set(indice, livro);
        return "redirect:/livros/listar";
    }

    @DeleteMapping("/livro/{indice}")
    public String alterar(@PathVariable int indice){
        if(indice >= 0 && indice < livros.size()){
            livros.remove(indice);
        }
        return "redirect:/livros/listar";
    }
}
