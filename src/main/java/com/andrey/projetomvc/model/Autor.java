package com.andrey.projetomvc.model;

import java.util.List;

public class Autor {
    private String nome;
    private String nacionalidade;
    private List<Livro> obrasPublicadas;

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
