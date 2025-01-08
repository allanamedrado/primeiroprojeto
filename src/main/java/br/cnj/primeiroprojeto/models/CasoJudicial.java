package br.cnj.primeiroprojeto.models;

public class CasoJudicial {
    int numero;
    char decisao;
    String descricao;

    public CasoJudicial(int numero, char decisao, String descricao) {
        this.numero = numero;
        this.descricao = descricao; 
        this.decisao = decisao; 
    }

    public char getDecisao() {
        return decisao;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getNumero() {
        return numero;
    }

    public void setDecisao(char decisao) {
        this.decisao = decisao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
