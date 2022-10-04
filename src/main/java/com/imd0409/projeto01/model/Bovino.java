package com.imd0409.projeto01.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.imd0409.projeto01.model.enums.Cor;
import com.imd0409.projeto01.model.enums.Sexo;

@Entity
@Table(name = "Bovino")
public class Bovino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome", length = 50)
    private String nome;

    @Column(name = "aniversario")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate aniversario;

    @Column(name = "sexo")
    private Sexo sexo;

    @Column(name = "cor")
    private Cor cor;
    
    @Column(name = "peso")
    private Float peso;

    @Column(name = "chifre")
    private Boolean chifre;

    @OneToOne(mappedBy = "bovino", fetch = FetchType.LAZY)
    private Vaca vaca;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCarteira", referencedColumnName = "id")
    private Carteira carteira;

    public Bovino() {
    }

    public Bovino(String nome, LocalDate aniversario, Sexo sexo, Cor cor, Float peso, Boolean chifre, Carteira carteira) {
        this.nome = nome;
        this.aniversario = aniversario;
        this.sexo = sexo;
        this.cor = cor;
        this.peso = peso;
        this.chifre = chifre;
        this.carteira = carteira;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getAniversario() {
        return this.aniversario;
    }

    public void setAniversario(LocalDate aniversario) {
        this.aniversario = aniversario;
    }

    public Sexo getSexo() {
        return this.sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Cor getCor() {
        return this.cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public Float getPeso() {
        return this.peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public Boolean isChifre() {
        return this.chifre;
    }

    public Boolean getChifre() {
        return this.chifre;
    }

    public void setChifre(Boolean chifre) {
        this.chifre = chifre;
    }

    public Vaca getVaca() {
        return this.vaca;
    }

    public void setVaca(Vaca vaca) {
        this.vaca = vaca;
    }

    public Carteira getCarteira() {
        return this.carteira;
    }

    public void setCarteira(Carteira carteira) {
        this.carteira = carteira;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nome='" + getNome() + "'" +
            ", aniversario='" + getAniversario() + "'" +
            ", sexo='" + getSexo() + "'" +
            ", cor='" + getCor() + "'" +
            ", peso='" + getPeso() + "'" +
            ", chifre='" + isChifre() + "'" +
            ", vaca='" + getVaca() + "'" +
            ", carteira='" + getCarteira() + "'" +
            "}";
    }
}