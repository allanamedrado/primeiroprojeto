package br.cnj.primeiroprojeto.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "CasosJudiciais")
public class CasoJudicial {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int numero;
    private char decisao;
    private String descricao;

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
