package br.com.challenge.forumhub.repository;

import br.com.challenge.forumhub.topico.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
}
