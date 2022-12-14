package com.imd0409.vacinacaobovino.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Carteira")
public class Carteira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "idBovino", referencedColumnName = "id")
    private Bovino bovino;

    @OneToMany(mappedBy = "carteira", fetch = FetchType.LAZY)
    private List<Aplicacao> aplicacoes;

    public Carteira() {
    }

    public Carteira(Bovino bovino, List<Aplicacao> aplicacoes) {
        this.bovino = bovino;
        this.aplicacoes = aplicacoes;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Bovino getBovino() {
        return this.bovino;
    }

    public void setBovino(Bovino bovino) {
        this.bovino = bovino;
    }

    public List<Aplicacao> getAplicacoes() {
        return this.aplicacoes;
    }

    public void setAplicacoes(List<Aplicacao> aplicacoes) {
        this.aplicacoes = aplicacoes;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", bovino='" + getBovino() + "'" +
            ", aplicacoes='" + getAplicacoes() + "'" +
            "}";
    }
}
