package br.com.challenge.forumhub.topico;

import java.time.LocalDateTime;

public record DadosListagemTopico(String titulo, String mensagem, String autor, String curso, LocalDateTime dataCriacao, TopicoStatus topicoStatus) {

    public DadosListagemTopico(Topico topico){
        this(topico.getTitulo(), topico.getMensagem(), topico.getAutor(), topico.getCurso(), topico.getDataCriacao(), topico.getTopicoStatus());
    }


}
