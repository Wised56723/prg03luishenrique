/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade08.view;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADM
 */
public class Main {     
    public static void main(String args[]) {

        System.out.println("\nCRIANDO CONTA:");

        ContaBanco contaBanco01 = new ContaBanco();
        ContaBanco contaBanco02 = new ContaBanco();
        ContaBanco contaBanco03 = new ContaBanco();

        contaBanco01.abrirConta(10, TipoContaEnum.CP, "Luan Alves");
        contaBanco02.abrirConta(20, TipoContaEnum.CC, "Lorena Alves");
        contaBanco03.abrirConta(30, TipoContaEnum.CP, "Leonado Alves");

        List<ContaBanco> contaBanco = new ArrayList<>();

        contaBanco.add(contaBanco01);
        contaBanco.add(contaBanco02);
        contaBanco.add(contaBanco03);

        for (ContaBanco conta : contaBanco) {
            System.out.println(conta.toString());
        }

        System.out.println("\nDEPOSITANDO NA CONTA:");
        contaBanco01.depositar(contaBanco, 10, 100F); // Deposita 100 na conta 10
        contaBanco02.depositar(contaBanco, 20, 200F); // Deposita 200 na conta 20

        for (ContaBanco conta : contaBanco) {
            System.out.println(conta.toString());
        }

        System.out.println("\nSACANDO DA CONTA:");
        contaBanco01.sacar(contaBanco, 10, 50F);  // Saca 50 da conta 10
        contaBanco03.sacar(contaBanco, 30, 100F); // Saca 100 da conta 30

        for (ContaBanco conta : contaBanco) {
            System.out.println(conta.toString());
        }

        System.out.println("\nEXCLUINDO CONTA:");
        contaBanco02.fecharConta(contaBanco, 20); // Tenta excluir a conta 20

        for (ContaBanco conta : contaBanco) {
            System.out.println(conta.toString());
        }
    }
}