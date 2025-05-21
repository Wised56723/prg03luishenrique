/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.atividade11.view;

/**
 *
 * @author luis2
 */

public class Main {
    public static void main(String[] args) {
        Forma[] formas = new Forma[] {
            new Circulo(3),
            new Quadrado(4),
            new Triangulo(5, 6),
            new Esfera(2),
            new Cubo(3),
            new Piramide(4, 5)
        };

        for (Forma forma : formas) {
            System.out.println(forma.toString());

            if (forma instanceof Forma2D) {
                Forma2D f2d = (Forma2D) forma;
                System.out.println("Tipo: 2D");
                System.out.println("Área: " + f2d.obterArea());
            } else if (forma instanceof Forma3D) {
                Forma3D f3d = (Forma3D) forma;
                System.out.println("Tipo: 3D");
                System.out.println("Área: " + f3d.obterArea());
                System.out.println("Volume: " + f3d.obterVolume());
            }

            System.out.println("-------------------------");
        }
    }
}
