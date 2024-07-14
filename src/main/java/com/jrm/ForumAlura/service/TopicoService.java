package com.jrm.ForumAlura.service;

import com.jrm.ForumAlura.dto.DadosCadastroTopico;
import com.jrm.ForumAlura.models.EstadoTopico;
import com.jrm.ForumAlura.models.Topico;
import com.jrm.ForumAlura.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TopicoService {
    @Autowired
    private TopicoRepository repository;

    @Autowired
    private TokenService tokenService;

    public Topico cadastrar(DadosCadastroTopico dados, String token){
        LocalDateTime data = LocalDateTime.now();

        var autor = tokenService.getSubject(token.replace("Bearer ", "")).split("@")[0];

        Topico topico = new Topico(null, dados.titulo(), dados.mensagem(), data, autor, dados.curso(), EstadoTopico.PRECISA_DE_RESPOSTA);
        repository.save(topico);
        return topico;
    }
}
