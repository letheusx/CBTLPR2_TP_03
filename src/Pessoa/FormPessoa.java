package Pessoa;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPessoa {
    private JFrame frame;
    private JTextField nomeField;
    private JTextField idadeField;
    private JComboBox<String> sexoCombo;
    private JTextField numeroField; // Não editável
    private Pessoa umaPessoa;

    public FormPessoa() {
        frame = new JFrame("Cadastro de Pessoa");
        frame.setLayout(new GridLayout(5, 2));

        // Campos do formulário
        frame.add(new JLabel("Número:"));
        numeroField = new JTextField();
        numeroField.setEditable(false);
        frame.add(numeroField);

        frame.add(new JLabel("Nome:"));
        nomeField = new JTextField();
        frame.add(nomeField);

        frame.add(new JLabel("Sexo:"));
        sexoCombo = new JComboBox<>(new String[]{"M", "F"});
        frame.add(sexoCombo);

        frame.add(new JLabel("Idade:"));
        idadeField = new JTextField();
        frame.add(idadeField);

        // Botões
        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nome = nomeField.getText();
                    char sexo = sexoCombo.getSelectedItem().toString().charAt(0);
                    int idade = Integer.parseInt(idadeField.getText());

                    umaPessoa = new Pessoa(nome, sexo, idade);
                    numeroField.setText(String.valueOf(Pessoa.getKp()));

                    JOptionPane.showMessageDialog(frame, "Pessoa cadastrada com sucesso!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        frame.add(okButton);

        JButton showButton = new JButton("Mostrar");
        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (umaPessoa != null) {
                    JOptionPane.showMessageDialog(frame,
                            "Nome: " + umaPessoa.getNome() +
                            "\nSexo: " + umaPessoa.getSexo() +
                            "\nIdade: " + umaPessoa.getIdade() +
                            "\nPessoas cadastradas: " + Pessoa.getKp());
                } else {
                    JOptionPane.showMessageDialog(frame, "Nenhuma pessoa cadastrada ainda.");
                }
            }
        });
        frame.add(showButton);

        // Configurações da janela
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new FormPessoa();
    }
}