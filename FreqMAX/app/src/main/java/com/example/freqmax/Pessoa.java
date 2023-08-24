package com.example.freqmax;

public class Pessoa {
    private Integer idade;
    private String nome;
    private Integer fcm;

    public Pessoa(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;
        this.fcm = 220 - idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Integer getFcm() {
        return fcm;
    }
}
