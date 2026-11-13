package com.andrey.projetomvc.model;

public class Livro {
    private String titutlo;
    private String autor;
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
