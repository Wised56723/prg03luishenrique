/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade10.view;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 *
 * @author luis2
 */


public class Usuario {
    private Long id;
    private PerfilUsuario perfil;
    private String nomeUsuario;
    private String email;
    private String senha;
    private LocalDateTime ultimoLogin;
    private Boolean ativo;

    public Usuario() {
    }

    public Usuario(Long id, PerfilUsuario perfil, String nomeUsuario, String email, String senha, LocalDateTime ultimoLogin, Boolean ativo) {
        this.id = id;
        this.perfil = perfil;
        this.nomeUsuario = nomeUsuario;
        this.email = email;
        this.senha = senha;
        this.ultimoLogin = ultimoLogin;
        this.ativo = ativo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PerfilUsuario getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilUsuario perfil) {
        this.perfil = perfil;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDateTime getUltimoLogin() {
        return ultimoLogin;
    }

    public void setUltimoLogin(LocalDateTime ultimoLogin) {
        this.ultimoLogin = ultimoLogin;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public LogAuditoria logar(String senha, String ip) {
        LocalDateTime now = LocalDateTime.now();
        String acao;
        if (this.senha.equals(senha)) {
            this.ultimoLogin = now;
            acao = "Login realizado com sucesso";
        } else {
            acao = "Tentativa de login falhou";
        }
        LogAuditoria log = new LogAuditoria();
        log.setUsuario(this);
        log.setAcao(acao);
        log.setDataHora(now);
        log.setIp(ip);
        return log;
    }

    public Sessao criarSessao() {
        String token = UUID.randomUUID().toString();
        Sessao sessao = new Sessao();
        sessao.setUsuario(this);
        sessao.setToken(token);
        return sessao;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", perfil=" + perfil + ", nomeUsuario=" + nomeUsuario + ", email=" + email + ", senha=" + senha + ", ultimoLogin=" + ultimoLogin + ", ativo=" + ativo + '}';
    }
}
