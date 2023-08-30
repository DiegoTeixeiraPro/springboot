package com.diego.springboot.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductRecordDto(@NotBlank String nomeProduto, @NotNull BigDecimal valorProduto) {
}


// A classe "record" é usada para definir uma estrutura de dados simples que possui campos, construtores,
// métodos padrão (como getters, equals, hashCode e toString) automaticamente gerados a partir dos campos declarados.
// Isso torna mais fácil e menos verboso criar classes de dados imutáveis.

// A anotação @NotBlank, faz com que o nome do produto não possa ser null, não pode ser uma String vazia.
// A anotação @NotNull, não poderá receber valores nulos para a base de dados