package com.diego.springboot.models;

import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "TB_PRODUTOS")
public class ProductModel extends RepresentationModel<ProductModel> implements Serializable {
    private static final long serialVersionIOD = 1L;

    // As anotações demonstram e definem como serão gerados os identificadores, "autogeração" de identificadores
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idProduto; //UUID é usado para garantir a unicidade global, o que é particularmente útil em ambientes distribuídos.
    private String nomeProduto;
    private BigDecimal valorProduto;


    public UUID getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(UUID idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public BigDecimal getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(BigDecimal valorProduto) {
        this.valorProduto = valorProduto;
    }
}