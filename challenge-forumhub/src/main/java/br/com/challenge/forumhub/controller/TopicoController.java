package br.com.challenge.forumhub.controller;

import br.com.challenge.forumhub.repository.TopicoRepository;
import br.com.challenge.forumhub.topico.DadosCadastroTopico;
import br.com.challenge.forumhub.topico.Topico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    @PostMapping
    public void cadastrarTopico(@RequestBody DadosCadastroTopico dados){
        repository.save(new Topico(dados));


    }


}
