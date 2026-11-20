package com.andrey.projetomvc.model;

import jakarta.validation.constraints.NotBlank;

public class Categoria {
    @NotBlank(message = "Informe o gênero")
    private String genero;

    public Categoria(){}

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
