package com.andrey.projetomvc.controller;

import com.andrey.projetomvc.model.Autor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/autores")
public class AutorController {

    private final List<Autor> autores = new ArrayList<>();

    @GetMapping("/autor")
    public String inicio(){
        return "autores/inicio";
    }


    @PostMapping("/autor")
    public String cadastrar(@ModelAttribute Autor autor){
        autores.add(autor);
        return "redirect:/livros";
    }

    @DeleteMapping("/autor/{indice}")
    public String alterar(@PathVariable int indice){
        if(indice >= 0 && indice < autores.size()){
            autores.remove(indice);
        }
        return "redirect:/autores";
    }
}
