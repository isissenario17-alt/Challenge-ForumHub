package br.com.challenge.forumhub.repository;

import br.com.challenge.forumhub.topico.DadosListagemTopico;
import br.com.challenge.forumhub.topico.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    List<DadosListagemTopico> findById();
}
