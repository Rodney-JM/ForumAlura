package com.jrm.ForumAlura.repository;

import com.jrm.ForumAlura.models.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
}
