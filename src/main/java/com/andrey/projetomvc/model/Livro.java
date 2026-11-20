package com.andrey.projetomvc.model;

import jakarta.validation.constraints.NotBlank;

public class Livro {
    @NotBlank(message = "Informe o título")
    private String titutlo;
    @NotBlank(message = "Informe o autor")
    private String autor;
    @NotBlank(message = "Informe o ISBN")
    private String isbn;

    public Livro(){}

    public Livro(String titutlo, String autor, String isbn) {
        this.titutlo = titutlo;
        this.autor = autor;
        this.isbn = isbn;
    }

    public String getTitutlo() {
        return titutlo;
    }

    public void setTitutlo(String titutlo) {
        this.titutlo = titutlo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
