/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade10.view;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author luis2
 */

public class Main {
    public static void main(String[] args) {
        List<String> permissoesAdmin = Arrays.asList("ADMIN", "GERENCIAR_USUARIOS");
        List<String> permissoesUser = Arrays.asList("USER", "VISUALIZAR_DADOS");

        PerfilUsuario perfilAdmin = new PerfilUsuario(1L, "Administrador", permissoesAdmin);
        PerfilUsuario perfilUser = new PerfilUsuario(2L, "Usuário Comum", permissoesUser);

        Usuario usuario1 = new Usuario();
        usuario1.setId(1L);
        usuario1.setPerfil(perfilAdmin);
        usuario1.setNomeUsuario("admin");
        usuario1.setEmail("admin@example.com");
        usuario1.setSenha("admin123");
        usuario1.setAtivo(true);

        Usuario usuario2 = new Usuario();
        usuario2.setId(2L);
        usuario2.setPerfil(perfilUser);
        usuario2.setNomeUsuario("user1");
        usuario2.setEmail("user1@example.com");
        usuario2.setSenha("user123");
        usuario2.setAtivo(true);

        Sessao sessao1 = usuario1.criarSessao();
        sessao1.setId(1L);

        Sessao sessao2 = usuario2.criarSessao();
        sessao2.setId(2L);

        List<LogAuditoria> logs = new ArrayList<>();

        LogAuditoria log1 = usuario1.logar("admin123", "192.168.1.100");
        log1.setId(1L);
        logs.add(log1);

        LogAuditoria log2 = usuario2.logar("wrongpass", "192.168.1.101");
        log2.setId(2L);
        logs.add(log2);

        System.out.println("Perfis de usuário:");
        System.out.println(perfilAdmin);
        System.out.println(perfilUser);

        System.out.println("\nUsuários:");
        System.out.println(usuario1);
        System.out.println(usuario2);

        System.out.println("\nSessões:");
        System.out.println(sessao1);
        System.out.println(sessao2);

        System.out.println("\nLogs de auditoria:");
        logs.forEach(System.out::println);
    }
}
