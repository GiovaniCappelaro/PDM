package com.giovani.pdm.havagas;

public class Candidato {

    private String nomeCompleto;
    private String email;
    private String telefone;
    private String celular; //*
    private String sexo;
    private String dataNascimento;
    private String formacao;
    private String anoFormatura; //*
    private String anoConclusao;
    private String instituicao;
    private String tituloMonografia;
    private String orientador;      //*
    private String vagasInteresse;
    //construtores:

    public Candidato(){}


    //Com os atributos COMUNS A TODOS
    public Candidato(String nomeCompleto, String email, String telefone, String sexo, String dataNascimento, String formacao, String vagasInteresse){
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.telefone = telefone;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.formacao = formacao;
        this.vagasInteresse = vagasInteresse;
    }

    //LEMBRETE: usar os setters pra definir atributos que variam (ex: tituloMonografia), após criar os comuns com o construtor na MainActivity !!!

    //getters e setters:
    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }


    public String getAnoFormatura() {
        return anoFormatura;
    }

    public void setAnoFormatura(String anoFormatura) {
        this.anoFormatura = anoFormatura;
    }

    public String getAnoConclusao() {
        return anoConclusao;
    }

    public void setAnoConclusao(String anoConclusao) {
        this.anoConclusao = anoConclusao;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public String getTituloMonografia() {
        return tituloMonografia;
    }

    public void setTituloMonografia(String tituloMonografia) {
        this.tituloMonografia = tituloMonografia;
    }

    public String getOrientador() {
        return orientador;
    }

    public void setOrientador(String orientador) {
        this.orientador = orientador;
    }

    public String getVagasInteresse() {
        return vagasInteresse;
    }

    public void setVagasInteresse(String vagasInteresse) {
        this.vagasInteresse = vagasInteresse;
    }

    //metodo toString

    @Override
    public String toString(){
        return "Candidato{" +
                "nomeCompleto'" + nomeCompleto +  '\'' +
                ", email='" + email +  '\'' +
                ", telefone='" + telefone +  '\'' +
                ", celular='"  + celular  +  '\'' +
                ", sexo='" + sexo +  '\'' +
                ", dataNascimento='" + dataNascimento  +  '\'' +
                ", formacao='" + formacao +  '\'' +
                ", anoFormatura='" + anoFormatura +  '\'' +
                ", anoConclusao='" + anoConclusao +  '\'' +
                ", instituicao='" + instituicao +  '\'' +
                ", tituloMonografia='" + tituloMonografia +  '\'' +
                ", orientador='" + orientador +  '\'' +
                '}';
    }


}
