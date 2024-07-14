package com.jrm.ForumAlura.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosAutenticacao(
        String login,
        String senha
) {
}
