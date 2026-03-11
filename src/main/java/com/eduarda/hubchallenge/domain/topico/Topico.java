package com.eduarda.hubchallenge.domain.topico;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;

    @Enumerated(EnumType.STRING)
    private StatusTopico status;

    private String autor;

    private String curso;

    public Topico() {}

    public Topico(DadosCadastroTopico dados){
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.autor = dados.autor();
        this.curso = dados.curso();
        this.status = StatusTopico.NAO_RESPONDIDO;
        this.dataCriacao = LocalDateTime.now();
    }

    public void atualizar(DadosAtualizacaoTopico dados){

        if (dados.titulo()!=null) {
            this.titulo = dados.titulo();
        }
        if (dados.mensagem()!=null) {
            this.mensagem = dados.mensagem();
        }
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public StatusTopico getStatus() {
        return status;
    }

    public String getAutor() {
        return autor;
    }

    public String getCurso() {
        return curso;
    }
}
