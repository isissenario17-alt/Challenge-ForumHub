package br.com.challenge.forumhub.topico;

import jakarta.persistence.*;
import jakarta.validation.Valid;

import java.time.LocalDateTime;

@Entity
@Table(name = "topicos")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;

    @Enumerated(EnumType.STRING)
    private TopicoStatus topicoStatus;
    private String autor;
    private String curso;

    public Topico(){}

    public Topico(DadosCadastroTopico dados) {
        this.autor = dados.autor();
        this.mensagem = dados.mensagem();
        this.curso = dados.curso();
        this.titulo = dados.titulo();
        this.topicoStatus = getTopicoStatus();
        this.dataCriacao = getDataCriacao();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public TopicoStatus getTopicoStatus() {
        return topicoStatus;
    }

    public void setTopicoStatus(TopicoStatus topicoStatus) {
        this.topicoStatus = topicoStatus;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Topico{" +
                "id=" + id +
                ", titulo='" + titulo  +
                ", mensagem='" + mensagem  +
                ", dataCriacao=" + dataCriacao +
                ", topicoStatus=" + topicoStatus +
                ", autor='" + autor  +
                ", curso='" + curso;
    }

    public void atualizarInformacoes(@Valid DadosAtualizacaoTopico dados) {
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.autor = dados.autor();
        this.curso = dados.curso();
    }
}
