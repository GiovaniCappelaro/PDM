package com.giovani.views;

public class Pessoa {
    private String nome;
    private String sobrenome;
    private String email;
    private String estadoCivil;
    private String sexo;

    public Pessoa() {
    }

    public Pessoa(String nome, String sobrenome, String email, String estadoCivil, String sexo) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.estadoCivil = estadoCivil;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", email='" + email + '\'' +
                ", estadoCivil='" + estadoCivil + '\'' +
                ", sexo='" + sexo + '\'' +
                '}';
    }
}

