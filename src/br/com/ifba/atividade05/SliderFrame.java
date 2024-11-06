package br.com.ifba.atividade05;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderFrame extends JFrame {

    // Declaração dos componentes
    private JSlider sliderMain;
    private JSlider sliderStart;
    private JSlider sliderEnd;
    private JSlider sliderStep;
    private JLabel labelValue;
    private JLabel labelStart;
    private JLabel labelEnd;
    private JLabel labelStep;

    public SliderFrame() {
        // Configuração da janela
        setTitle("Slider Configurável");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 350);
        setLocationRelativeTo(null);
        setLayout(null);

        // Inicializar os sliders
        sliderMain = new JSlider();
        sliderStart = new JSlider(0, 100, 0);  // Início: 0 a 100
        sliderEnd = new JSlider(0, 200, 100);  // Fim: 0 a 200
        sliderStep = new JSlider(1, 20, 10);   // Passo: 1 a 20

        // Inicializar os labels
        labelValue = new JLabel("Valor Atual: " + sliderMain.getValue());
        labelStart = new JLabel("Início: " + sliderStart.getValue());
        labelEnd = new JLabel("Fim: " + sliderEnd.getValue());
        labelStep = new JLabel("Passo: " + sliderStep.getValue());

        // Configuração dos sliders
        sliderMain.setMinimum(sliderStart.getValue());
        sliderMain.setMaximum(sliderEnd.getValue());
        sliderMain.setValue(sliderStart.getValue());
        sliderMain.setMajorTickSpacing(sliderStep.getValue());
        sliderMain.setPaintTicks(true);
        sliderMain.setPaintLabels(true);
        sliderMain.setBounds(50, 50, 400, 50);

        sliderStart.setBounds(50, 120, 400, 50);
        sliderEnd.setBounds(50, 180, 400, 50);
        sliderStep.setBounds(50, 240, 400, 50);

        labelValue.setBounds(50, 300, 300, 30);
        labelStart.setBounds(50, 90, 300, 30);
        labelEnd.setBounds(50, 160, 300, 30);
        labelStep.setBounds(50, 220, 300, 30);

        // Adicionando os componentes à janela
        add(sliderMain);
        add(sliderStart);
        add(sliderEnd);
        add(sliderStep);
        add(labelValue);
        add(labelStart);
        add(labelEnd);
        add(labelStep);

        // Listener do slider principal para atualizar o valor exibido
        sliderMain.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                labelValue.setText("Valor Atual: " + sliderMain.getValue());
            }
        });

        // Listener para o Slider de Início
        sliderStart.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int start = sliderStart.getValue();
                labelStart.setText("Início: " + start);
                // Atualiza o valor mínimo do slider principal
                sliderMain.setMinimum(start);
                // Garante que o valor do slider principal não ultrapasse o novo limite
                if (sliderMain.getValue() < start) {
                    sliderMain.setValue(start);
                }
            }
        });

        // Listener para o Slider de Fim
        sliderEnd.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int end = sliderEnd.getValue();
                labelEnd.setText("Fim: " + end);
                // Atualiza o valor máximo do slider principal
                sliderMain.setMaximum(end);
                // Garante que o valor do slider principal não ultrapasse o novo limite
                if (sliderMain.getValue() > end) {
                    sliderMain.setValue(end);
                }
            }
        });

        // Listener para o Slider de Passo
        sliderStep.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int step = sliderStep.getValue();
                labelStep.setText("Passo: " + step);
                // Atualiza o passo (spacing) do slider principal
                sliderMain.setMajorTickSpacing(step);
                sliderMain.setPaintTicks(true);
                sliderMain.setPaintLabels(true);
            }
        });
    }

    public static void main(String[] args) {
        // Exibir o SliderFrame
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SliderFrame().setVisible(true);
            }
        });
    }
}



