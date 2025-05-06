/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade07.view;

/**
 *
 * @author ADM
 */
public class CalculoFatorial {
    private int valor;

    public void setValor(int n) {
        this.valor = n;
    }

    public int getFatorial() {
        if (valor == 0 || valor == 1) {
            return 1;
        }
        int resultado = 1;
        for (int i = 2; i <= valor; i++) {
            resultado *= i;
        }
        return resultado;
    }

    public String getFormula() {
        if (valor == 0) {
            return "0 = 1";
        }
        StringBuilder formula = new StringBuilder();
        for (int i = valor; i >= 1; i--) {
            formula.append(i);
            if (i != 1) {
                formula.append(" x ");
            }
        }
        formula.append(" = ").append(getFatorial());
        return formula.toString();
    }
}
