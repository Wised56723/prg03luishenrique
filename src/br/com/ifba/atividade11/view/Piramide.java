/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade11.view;

/**
 *
 * @author luis2
 */

public class Piramide extends Forma3D {
    private double base, altura;

    public Piramide(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double obterArea() {
        return base * base + 2 * base * (altura / 2); // área da base + 2 triângulos laterais (simplificado)
    }

    @Override
    public double obterVolume() {
        return (1.0 / 3.0) * (base * base) * altura;
    }

    @Override
    public String toString() {
        return "Pirâmide com base " + base + " e altura " + altura;
    }
}

