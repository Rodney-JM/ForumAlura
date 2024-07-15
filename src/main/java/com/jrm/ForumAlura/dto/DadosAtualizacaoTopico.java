package com.jrm.ForumAlura.dto;

import com.jrm.ForumAlura.models.EstadoTopico;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAtualizacaoTopico (
        @NotNull
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime data,
        EstadoTopico estadoTopico
){
}
