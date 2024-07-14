package com.jrm.ForumAlura.dto;

import com.jrm.ForumAlura.models.EstadoTopico;
import com.jrm.ForumAlura.models.Topico;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

import java.time.LocalDateTime;

public record DadosDetalhamentoTopico (
        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        String autor,
        String curso,
        EstadoTopico estadoTopico
){
    public DadosDetalhamentoTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.getAutor(), topico.getCurso(), topico.getEstadoTopico());
    }
}
