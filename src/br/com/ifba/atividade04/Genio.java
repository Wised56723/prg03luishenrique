package br.com.ifba.atividade04;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Genio {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Adivinhador de Números");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(null);

        JLabel promptLabel = new JLabel("Digite um número de 1 a 5:");
        promptLabel.setBounds(20, 20, 250, 25);
        frame.add(promptLabel);

        JTextField inputField = new JTextField();
        inputField.setBounds(20, 50, 50, 25);
        frame.add(inputField);

        JButton guessButton = new JButton("Palpitar");
        guessButton.setBounds(80, 50, 100, 25);
        frame.add(guessButton);

        JLabel resultLabel = new JLabel("");
        resultLabel.setBounds(20, 90, 250, 25);
        frame.add(resultLabel);

        // Gênio pensa em um número aleatório de 1 a 5
        Random random = new Random();
        int numeroPensado = random.nextInt(5) + 1;

        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int palpite = Integer.parseInt(inputField.getText());
                    if (palpite < 1 || palpite > 5) {
                        resultLabel.setText("Por favor, digite um número entre 1 e 5.");
                    } else if (palpite == numeroPensado) {
                        resultLabel.setText("Parabéns! Você adivinhou o número!");
                    } else {
                        resultLabel.setText("Errou! O número pensado era: " + numeroPensado);
                    }
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Por favor, insira um número válido.");
                }
            }
        });

        frame.setVisible(true);
    }
}