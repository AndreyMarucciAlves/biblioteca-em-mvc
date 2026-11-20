package com.andrey.projetomvc.controller;

import com.andrey.projetomvc.model.Categoria;
import org.springframework.stereotype.Controller;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    private final List<Categoria> categorias = new ArrayList<>();

    @GetMapping
    public String listar(Model model){
        model.addAttribute("categorias", categorias);
        return "categorias/lista";
    }

    @GetMapping("/categoria")
    public String novo(Model model){
        model.addAttribute("categoria", new Categoria());
        return "categorias/form";
    }

    @PostMapping("/categoria")
    public String cadastrar(@Valid @ModelAttribute Categoria categoria, BindingResult result){
        if(result.hasErrors()){
            return "categorias/form";
        }
        categorias.add(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/categoria/{indice}")
    public String editar(@PathVariable int indice, Model model){
        model.addAttribute("categoria", categorias.get(indice));
        model.addAttribute("indice", indice);
        return "categorias/form";
    }

    @PutMapping("/categoria/{indice}")
    public String atualizar(@PathVariable int indice, @Valid @ModelAttribute Categoria categoria, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("indice", indice);
            return "categorias/form";
        }
        categorias.set(indice, categoria);
        return "redirect:/categorias";
    }

    @DeleteMapping("/categoria/{indice}")
    public String excluir(@PathVariable int indice){
        if(indice >= 0 && indice < categorias.size()){
            categorias.remove(indice);
        }
        return "redirect:/categorias";
    }
}
