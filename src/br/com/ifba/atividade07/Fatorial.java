package br.com.ifba.atividade07;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Fatorial extends JFrame {

    private JTextField jTextField; // Campo de texto para inserir o número
    private JLabel resultLabel;    // Label para exibir o resultado
    private JLabel formulaLabel;   // Label para exibir a fórmula do cálculo
    private JButton calculateButton; // Botão para calcular o fatorial

    // Construtor da classe
    public Fatorial() {
        // Definindo título da janela
        setTitle("Calculadora de Fatorial");
        
        // Configurações básicas da janela
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setLayout(new FlowLayout()); // Layout simples com FlowLayout

        // Criando os componentes
        jTextField = new JTextField(10);
        resultLabel = new JLabel("Resultado: ");
        formulaLabel = new JLabel("Fórmula: ");
        calculateButton = new JButton("Calcular Fatorial");

        // Adicionando os componentes à janela
        add(new JLabel("Digite um número:"));
        add(jTextField);
        add(calculateButton);
        add(formulaLabel);
        add(resultLabel);

        // Ação do botão para calcular o fatorial
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtendo o número inserido
                String inputText = jTextField.getText();
                try {
                    int number = Integer.parseInt(inputText);

                    // Calculando o fatorial e criando a fórmula
                    if (number >= 0) {
                        long factorial = calculateFactorial(number);
                        String formula = buildFormula(number);

                        // Exibindo o resultado e a fórmula na interface
                        resultLabel.setText("Resultado: " + factorial);
                        formulaLabel.setText("Fórmula: " + formula);
                    } else {
                        // Caso o número seja negativo, mostrar uma mensagem de erro
                        JOptionPane.showMessageDialog(null, "Por favor, insira um número não negativo.");
                    }
                } catch (NumberFormatException ex) {
                    // Caso o valor inserido não seja um número válido
                    JOptionPane.showMessageDialog(null, "Por favor, insira um número válido.");
                }
            }
        });
    }

    // Método para calcular o fatorial de um número
    private long calculateFactorial(int number) {
        long result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }

    // Método para gerar a fórmula do cálculo do fatorial
    private String buildFormula(int number) {
        StringBuilder formula = new StringBuilder(number + "!");
        for (int i = number - 1; i > 0; i--) {
            formula.append(" × ").append(i);
        }
        return formula.toString();
    }

    // Método principal para rodar a aplicação
    public static void main(String[] args) {
        // Criando e exibindo a janela
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Fatorial().setVisible(true);
            }
        });
    }
}

