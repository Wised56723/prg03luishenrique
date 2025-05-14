/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade09.view;

/**
 *
 * @author luis2
 */
public class PagamentoCartao implements Pagamento {
    private final double valor;

    public PagamentoCartao(double valor) {
        this.valor = valor;
    }

    @Override
    public double calcularTotal() {
        return valor * 1.05; // 5% de taxa
    }

    @Override
    public String imprimirRecibo() {
        return String.format("""
                           RECIBO (CARTÃO)
                           Valor original: R$%.2f
                           Taxa (5%%): R$%.2f
                           Total a pagar: R$%.2f
                           """, valor, valor * 0.05, calcularTotal());
    }
}
