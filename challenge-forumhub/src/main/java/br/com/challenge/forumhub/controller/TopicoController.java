package br.com.challenge.forumhub.controller;

import br.com.challenge.forumhub.repository.TopicoRepository;
import br.com.challenge.forumhub.topico.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    public void cadastrarTopico(@RequestBody @Valid DadosCadastroTopico dados){
        repository.save(new Topico(dados));
    }

    @GetMapping
    public Page<DadosListagemTopico> listarTopicos(@PageableDefault(size = 10, sort = {"autor"}) Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemTopico :: new);
    }

    @GetMapping("/{id}")
    public Optional<Topico> listarTopicoEspecifico(@PathVariable Long id){
        return repository.findById(id);
    }

    @PutMapping
    public void atualizarTopico(@RequestBody @Valid DadosAtualizacaoTopico dados){
        var topico = repository.getReferenceById(dados.id());
        topico.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    public void excluirTopico(@PathVariable Long id){
        repository.deleteById(id);
    }

}
