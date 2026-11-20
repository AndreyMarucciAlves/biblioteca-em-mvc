package com.andrey.projetomvc.controller;

import com.andrey.projetomvc.model.Usuario;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UsuarioController {

    private final List<Usuario> usuarios = new ArrayList<>();

    @GetMapping("/")
    public String inicio(){
        return "redirect:/usuarios/login";
    }

    @GetMapping("/usuarios/login")
    public String login(Model model){
        model.addAttribute("usuario", new Usuario());
        return "usuarios/login";
    }

    @PostMapping("/usuarios/login")
    public String entrar(@RequestParam String login, @RequestParam String senha, Model model){
        for(Usuario usuario : usuarios){
            if(usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)){
                return "redirect:/livros";
            }
        }
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("erroLogin", "Login ou senha inválidos");
        return "usuarios/login";
    }

    @PostMapping("/usuarios/registro")
    public String registrar(@Valid @ModelAttribute Usuario usuario, BindingResult result, Model model){
        if(result.hasErrors()){
            return "usuarios/login";
        }
        usuarios.add(usuario);
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("sucesso", "Cadastro feito, agora faça o login");
        return "usuarios/login";
    }
}
