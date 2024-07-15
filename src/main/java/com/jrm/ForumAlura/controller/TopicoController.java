package com.jrm.ForumAlura.controller;

import com.jrm.ForumAlura.dto.DadosAtualizacaoTopico;
import com.jrm.ForumAlura.dto.DadosCadastroTopico;
import com.jrm.ForumAlura.dto.DadosDetalhamentoTopico;
import com.jrm.ForumAlura.dto.TopicoDTO;
import com.jrm.ForumAlura.service.TopicoService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Objects;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    @Autowired
    private TopicoService service;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroTopico dados, UriComponentsBuilder uriBuilder, HttpServletRequest request){
        var topico = service.cadastrar(dados, request.getHeader("Authorization"));

        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoTopico(topico));
    }

    @GetMapping
    public ResponseEntity<Page<TopicoDTO>> mostrarTopicos(@PageableDefault(size = 10, sort = "estadoTopico")Pageable pageable){
        var page = service.mostrarTopicos(pageable);

        return ResponseEntity.ok().body(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var topico = service.detalharTopico(id);
        return ResponseEntity.ok(topico);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoTopico dadosAtualizacaoTopico){
        var topico = service.atualizar(dadosAtualizacaoTopico);

        return ResponseEntity.ok(new DadosDetalhamentoTopico(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id){
        service.deletar(id);

        return ResponseEntity.noContent().build();
    }
}
