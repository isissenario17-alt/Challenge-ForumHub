package br.com.challenge.forumhub.topico;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record DadosListagemTopico(Long id, String titulo, String mensagem, String autor, String curso, @JsonFormat(pattern = "dd/MM/yyyy HH:mm")LocalDateTime dataCriacao, TopicoStatus topicoStatus) {

    public DadosListagemTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getAutor(), topico.getCurso(), topico.getDataCriacao(), topico.getTopicoStatus());
    }


}
