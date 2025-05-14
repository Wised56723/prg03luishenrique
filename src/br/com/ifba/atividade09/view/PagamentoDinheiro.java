/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade09.view;

/**
 *
 * @author luis2
 */
public class PagamentoDinheiro implements Pagamento {
    private final double valor;

    public PagamentoDinheiro(double valor) {
        this.valor = valor;
    }

    @Override
    public double calcularTotal() {
        return valor * 0.90; // 10% de desconto
    }

    @Override
    public String imprimirRecibo() {
        return String.format("""
                           RECIBO (DINHEIRO)
                           Valor original: R$%.2f
                           Desconto (10%%): R$%.2f
                           Total a pagar: R$%.2f
                           """, valor, valor * 0.10, calcularTotal());
    }
}
