/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade09.view;

/**
 *
 * @author luis2
 */
public class PagamentoPix implements Pagamento {
    private final double valor;

    public PagamentoPix(double valor) {
        this.valor = valor;
    }

    @Override
    public double calcularTotal() {
        return valor * 0.98; // 2% de cashback
    }

    @Override
    public String imprimirRecibo() {
        return String.format("""
                           RECIBO (PIX)
                           Valor original: R$%.2f
                           Cashback (2%%): R$%.2f
                           Total a pagar: R$%.2f
                           """, valor, valor * 0.02, calcularTotal());
    }
}
