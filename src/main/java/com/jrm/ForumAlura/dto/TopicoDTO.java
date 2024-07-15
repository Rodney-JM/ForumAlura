package com.jrm.ForumAlura.dto;

import com.jrm.ForumAlura.models.EstadoTopico;

import java.time.LocalDateTime;

public record TopicoDTO (
            Long id,
            String titulo,
            String mensagem,
            LocalDateTime data,
            EstadoTopico estadoTopico,
            String curso
){
}
