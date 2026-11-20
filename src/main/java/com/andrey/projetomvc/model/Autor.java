package com.andrey.projetomvc.model;

import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

public class Autor {
    @NotBlank(message = "Informe o nome")
    private String nome;
    @NotBlank(message = "Informe a nacionalidade")
    private String nacionalidade;
    private List<Livro> obrasPublicadas;

    public Autor() {
        this.obrasPublicadas = new ArrayList<>();
    }

    public Autor(String nome, String nacionalidade, List<Livro> obrasPublicadas) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.obrasPublicadas = obrasPublicadas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public List<Livro> addBibliografia(Livro livro){
        this.obrasPublicadas.add(livro);
        return this.obrasPublicadas;
    }
    public List<Livro> getObrasPublicadas() {
        return obrasPublicadas;
    }

    public void setObrasPublicadas(List<Livro> obrasPublicadas) {
        this.obrasPublicadas = obrasPublicadas;
    }
}
