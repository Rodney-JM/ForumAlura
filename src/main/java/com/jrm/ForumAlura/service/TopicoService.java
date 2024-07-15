package com.jrm.ForumAlura.service;

import com.jrm.ForumAlura.dto.DadosAtualizacaoTopico;
import com.jrm.ForumAlura.dto.DadosCadastroTopico;
import com.jrm.ForumAlura.dto.DadosDetalhamentoTopico;
import com.jrm.ForumAlura.dto.TopicoDTO;
import com.jrm.ForumAlura.infra.exceptions.ValidacaoException;
import com.jrm.ForumAlura.models.EstadoTopico;
import com.jrm.ForumAlura.models.Topico;
import com.jrm.ForumAlura.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    public Page<TopicoDTO> mostrarTopicos(Pageable pageable){
        return repository.findAll(pageable)
                .map(t -> new TopicoDTO(t.getId(),t.getTitulo(), t.getMensagem(), t.getDataCriacao(), t.getEstadoTopico(), t.getAutor()));
    }

    public DadosDetalhamentoTopico detalharTopico(Long id) {
        var topico = repository.getReferenceById(id);
        return new DadosDetalhamentoTopico(topico);
    }

    public Topico atualizar(DadosAtualizacaoTopico dadosAtualizacaoTopico){
        var topico = repository.getReferenceById(dadosAtualizacaoTopico.id());

        topico.atualizarInformacoes(dadosAtualizacaoTopico);

        return topico;
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
