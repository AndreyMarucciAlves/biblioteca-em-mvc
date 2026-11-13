package com.andrey.projetomvc.model;

public class Categoria {
    private String genero;

    public Categoria(String genero) {
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
