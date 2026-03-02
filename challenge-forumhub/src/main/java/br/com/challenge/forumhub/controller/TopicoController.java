package br.com.challenge.forumhub.controller;

import br.com.challenge.forumhub.repository.TopicoRepository;
import br.com.challenge.forumhub.topico.DadosCadastroTopico;
import br.com.challenge.forumhub.topico.DadosListagemTopico;
import br.com.challenge.forumhub.topico.Topico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    public void cadastrarTopico(@RequestBody DadosCadastroTopico dados){
        repository.save(new Topico(dados));
    }

    @GetMapping
    public Page<DadosListagemTopico> listarTopico(@PageableDefault(size = 10, sort = {"autor"}) Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemTopico :: new);
    }

    @GetMapping("/{id}")
    public List<DadosListagemTopico> detalharTopico(@PathVariable Long id){
        return repository.findById();
    }


}
