package com.andrey.projetomvc.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class Emprestimo {
    @NotBlank(message = "Informe o titular")
    private String nomeTitular;
    @NotBlank(message = "Informe o livro")
    private String nomeLivro;
    @NotNull(message = "Informe a data do empréstimo")
    private LocalDateTime dataEmprestimo;
    private LocalDateTime dataDevolucao;
    private LocalDateTime dataDevolvido;

    public Emprestimo(){}

    public Emprestimo(String nomeTitular, String nomeLivro, LocalDateTime dataEmprestimo, LocalDateTime dataDevolvido) {
        this.nomeTitular = nomeTitular;
        this.nomeLivro = nomeLivro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataEmprestimo.plusDays(5);
        this.dataDevolvido = dataDevolvido;
    }

    public boolean registrarRecebimentoDevolucao(){
        this.dataDevolucao = LocalDateTime.now();
        return true;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public LocalDateTime getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDateTime dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDateTime getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDateTime dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public LocalDateTime getDataDevolvido() {
        return dataDevolvido;
    }

    public void setDataDevolvido(LocalDateTime dataDevolvido) {
        this.dataDevolvido = dataDevolvido;
    }
}
