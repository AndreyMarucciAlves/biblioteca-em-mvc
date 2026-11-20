package com.andrey.projetomvc.controller;

import com.andrey.projetomvc.model.Autor;
import com.andrey.projetomvc.model.Livro;
import org.springframework.stereotype.Controller;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/autores")
public class AutorController {

    private final List<Autor> autores = new ArrayList<>();

    public AutorController() {
        Autor machado = new Autor("Machado de Assis", "Brasileira", new ArrayList<>());
        machado.addBibliografia(new Livro("Dom Casmurro", "Machado de Assis", "978-85-01"));
        machado.addBibliografia(new Livro("Memórias Póstumas de Brás Cubas", "Machado de Assis", "978-85-02"));
        autores.add(machado);
    }

    @GetMapping
    public String listar(Model model){
        model.addAttribute("autores", autores);
        return "autores/lista";
    }

    @GetMapping("/autor")
    public String inicio(Model model){
        model.addAttribute("autor", new Autor());
        return "autores/form";
    }

    @PostMapping("/autor")
    public String cadastrar(@Valid @ModelAttribute Autor autor, BindingResult result){
        if(result.hasErrors()){
            return "autores/form";
        }
        autores.add(autor);
        return "redirect:/autores";
    }

    @GetMapping("/autor/{indice}")
    public String editar(@PathVariable int indice, Model model){
        model.addAttribute("autor", autores.get(indice));
        model.addAttribute("indice", indice);
        return "autores/form";
    }

    @PutMapping("/autor/{indice}")
    public String atualizar(@PathVariable int indice, @Valid @ModelAttribute Autor dados, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("indice", indice);
            return "autores/form";
        }
        Autor autor = autores.get(indice);
        autor.setNome(dados.getNome());
        autor.setNacionalidade(dados.getNacionalidade());
        return "redirect:/autores";
    }

    @DeleteMapping("/autor/{indice}")
    public String alterar(@PathVariable int indice){
        if(indice >= 0 && indice < autores.size()){
            autores.remove(indice);
        }
        return "redirect:/autores";
    }

    @GetMapping("/obras/{indice}")
    public String detalharObras(@PathVariable int indice, Model model) {
        model.addAttribute("autor", autores.get(indice));
        model.addAttribute("indice", indice);
        model.addAttribute("novoLivro", new Livro());
        return "autores/obras/detalhe";
    }

    @PostMapping("/obras/{indice}/livros")
    public String adicionarLivro(@PathVariable int indice, @ModelAttribute("novoLivro") Livro livro) {
        Autor autor = autores.get(indice);
        livro.setAutor(autor.getNome());
        autor.addBibliografia(livro);
        return "redirect:/autores/obras/" + indice;
    }
}
