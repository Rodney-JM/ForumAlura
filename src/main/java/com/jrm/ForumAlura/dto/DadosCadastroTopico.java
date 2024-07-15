package com.jrm.ForumAlura.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroTopico (
        @NotBlank
        String titulo,
        @NotBlank
        String mensagem,
        @NotBlank
        String curso
){
}
