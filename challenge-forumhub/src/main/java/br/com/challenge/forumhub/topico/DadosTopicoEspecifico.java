package br.com.challenge.forumhub.topico;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record DadosTopicoEspecifico(String titulo, String mensagem, String autor, String curso, @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
                                    LocalDateTime dataCriacao, TopicoStatus topicoStatus) {
}
