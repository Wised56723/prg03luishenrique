package br.com.ifba.atividade06;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;


public class Vetor extends javax.swing.JFrame {

    private static final int VECTOR_SIZE = 10;
    private int[] vector = new int[VECTOR_SIZE]; // Vetor de 10 elementos
    
    // Construtor da classe Vetor
    public Vetor() {
        initComponents(); // Inicializa os componentes gráficos
        Arrays.fill(vector, 0); // Inicializa o vetor com zeros
        updateList(); // Atualiza a JList com os valores iniciais
    }
    
    // Método para atualizar a JList com os valores do vetor
    private void updateList() {
        DefaultListModel<String> listModel = (DefaultListModel<String>) jList1.getModel();
        listModel.clear();
        for (int i = 0; i < VECTOR_SIZE; i++) {
            listModel.addElement("[" + i + "] -> " + vector[i]);
        }
    }

    // Método gerado automaticamente pelo NetBeans (não mexa nele)
    private void initComponents() {

        jTextFieldValue = new javax.swing.JTextField();
        jTextFieldIndex = new javax.swing.JTextField();
        jButtonAdd = new javax.swing.JButton();
        jButtonRemove = new javax.swing.JButton();
        jButtonSort = new javax.swing.JButton();
        jButtonSelect = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonAdd.setText("Adicionar");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonRemove.setText("Remover");
        jButtonRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveActionPerformed(evt);
            }
        });

        jButtonSort.setText("Ordenar");
        jButtonSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSortActionPerformed(evt);
            }
        });

        jButtonSelect.setText("Selecionar Índice");

        // Configuração do modelo da JList
        jList1.setModel(new DefaultListModel<>());
        jScrollPane1.setViewportView(jList1);

        // Layout do JFrame
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldValue)
                            .addComponent(jTextFieldIndex, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonSort, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonSelect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextFieldValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldIndex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAdd)
                    .addComponent(jButtonRemove))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSort)
                    .addComponent(jButtonSelect))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    // Ações dos botões

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            int value = Integer.parseInt(jTextFieldValue.getText());
            int index = Integer.parseInt(jTextFieldIndex.getText());
            if (index >= 0 && index < VECTOR_SIZE) {
                vector[index] = value;
                updateList(); // Atualiza a JList
            } else {
                JOptionPane.showMessageDialog(this, "Índice inválido.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira valores válidos.");
        }
    }

    private void jButtonRemoveActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            int index = Integer.parseInt(jTextFieldIndex.getText());
            if (index >= 0 && index < VECTOR_SIZE) {
                vector[index] = 0; // Remover valor, colocando 0 no índice
                updateList(); // Atualiza a JList
            } else {
                JOptionPane.showMessageDialog(this, "Índice inválido.");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira um índice válido.");
        }
    }

    private void jButtonSortActionPerformed(java.awt.event.ActionEvent evt) {
        Arrays.sort(vector);
        for (int i = 0; i < vector.length / 2; i++) {
            int temp = vector[i];
            vector[i] = vector[vector.length - i - 1];
            vector[vector.length - i - 1] = temp;
        }
        updateList(); // Atualiza a JList
    }

    // Componentes da GUI
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonRemove;
    private javax.swing.JButton jButtonSelect;
    private javax.swing.JButton jButtonSort;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JTextField jTextFieldIndex;
    private javax.swing.JTextField jTextFieldValue;
}