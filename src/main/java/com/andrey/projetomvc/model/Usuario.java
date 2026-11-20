package com.andrey.projetomvc.model;

import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    @NotBlank(message = "Informe o nome")
    private String nome;
    @NotBlank(message = "Informe o login")
    private String login;
    @NotBlank(message = "Informe a senha")
    private String senha;
    private List<Emprestimo> listaEmprestimos;

    public Usuario() {
        this.listaEmprestimos = new ArrayList<>();
    }

    public Usuario(String nome, String login, String senha, List<Emprestimo> listaEmprestimos) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.listaEmprestimos = listaEmprestimos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Emprestimo> getListaEmprestimos() {
        return listaEmprestimos;
    }

    public void setListaEmprestimos(List<Emprestimo> listaEmprestimos) {
        this.listaEmprestimos = listaEmprestimos;
    }
}
