package atividades_poo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraIdade {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora de Idade");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 250);
        frame.setLayout(null);

        // Adicionando o ícone da calculadora
        ImageIcon calculadoraIcon = new ImageIcon("src/images/calculadora.png");
        JLabel iconLabel = new JLabel(calculadoraIcon);
        iconLabel.setBounds(20, 10, 50, 50); // Ajuste as dimensões conforme necessário
        frame.add(iconLabel);

        JLabel label = new JLabel("Digite seu ano de nascimento:");
        label.setBounds(20, 70, 250, 25);
        frame.add(label);

        JTextField anoNascimento = new JTextField();
        anoNascimento.setBounds(20, 100, 100, 25);
        frame.add(anoNascimento);

        JButton calcularButton = new JButton("Calcular Idade");
        calcularButton.setBounds(130, 100, 150, 25);
        frame.add(calcularButton);

        JLabel resultadoLabel = new JLabel("Sua idade: ");
        resultadoLabel.setBounds(20, 130, 250, 25);
        frame.add(resultadoLabel);

        // Adicionando o ícone do usuário
        ImageIcon usuarioIcon = new ImageIcon("src/images/usuario.png");
        JLabel usuarioLabel = new JLabel(usuarioIcon);
        usuarioLabel.setBounds(20, 160, 50, 50); // Ajuste as dimensões conforme necessário
        frame.add(usuarioLabel);

        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int anoNasc = Integer.parseInt(anoNascimento.getText());
                    int anoAtual = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
                    int idade = anoAtual - anoNasc;
                    resultadoLabel.setText("Sua idade: " + idade);
                } catch (NumberFormatException ex) {
                    resultadoLabel.setText("Por favor, insira um ano válido.");
                }
            }
        });

        frame.setVisible(true);
    }
}
