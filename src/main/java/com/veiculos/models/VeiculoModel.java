package com.veiculos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import org.springframework.hateoas.RepresentationModel;


@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class VeiculoModel extends RepresentationModel<VeiculoModel> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    @NotBlank
    private String marca;
    @NotBlank
    private String modelo;
    @NotBlank
    private String motor;
    @NotBlank
    private String ano;
    @NotBlank
    private String cor;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}
