package Calculadora;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora extends JFrame implements ActionListener {

    private JTextField textField;
    private double resultado;
    private String operador;
    private boolean novoNumero;

    public Calculadora() {
        setTitle("Calculadora");
        setSize(250, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Criação do campo de texto onde o resultado será mostrado
        textField = new JTextField("0");
        textField.setEditable(false);
        textField.setMargin(new Insets(10, 10, 10, 10));
        textField.setHorizontalAlignment(JTextField.RIGHT);
        add(textField, BorderLayout.NORTH);

        // Criação dos botões da calculadora
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.addActionListener(this);
            panel.add(button);
        }

        add(panel, BorderLayout.CENTER);
        
        resultado = 0;
        operador = "=";
        novoNumero = true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        try {
            // Se o comando for um número ou ponto, ele é adicionado à tela
            if ("0123456789.".contains(comando)) {
                if (novoNumero) {
                    textField.setText(comando);
                    novoNumero = false;
                } else {
                    textField.setText(textField.getText() + comando);
                }
            } 
            // Se for "C", o cálculo é resetado
            else if (comando.equals("C")) {
                textField.setText("0");
                resultado = 0;
                operador = "=";
                novoNumero = true;
            } else {
                // Quando um operador é pressionado, realiza o cálculo
                if (!novoNumero) {
                    calculate(Double.parseDouble(textField.getText()));
                    novoNumero = true;
                }
                operador = comando;
            }
        } catch (NumberFormatException ex) {
            // Caso ocorra um erro ao converter o valor para número, exibe "Error"
            textField.setText("Error");
        } catch (ArithmeticException ex) {
            // Tratamento para erros de divisão por zero
            textField.setText("Error");
        } finally {
            // Quando "=" for pressionado, mostra o resultado final
            if (comando.equals("=")) {
                textField.setText("" + resultado);
            }
        }
    }

    private void calculate(double numero) {
        try {
            // Realiza os cálculos de acordo com o operador escolhido
            switch (operador) {
                case "+":
                    resultado += numero;
                    break;
                case "-":
                    resultado -= numero;
                    break;
                case "*":
                    resultado *= numero;
                    break;
                case "/":
                    if (numero != 0) {
                        resultado /= numero;
                    } else {
                        throw new ArithmeticException("Divisão por zero");
                    }
                    break;
                case "=":
                    resultado = numero;
                    break;
                default:
                    throw new IllegalArgumentException("Operador desconhecido");
            }
        } catch (ArithmeticException ex) {
            // Captura erro de divisão por zero e exibe "Error"
            textField.setText("Error");
        } catch (IllegalArgumentException ex) {
            // Captura caso um operador inválido seja passado
            textField.setText("Error");
        }
    }

    public static void main(String[] args) {
        // Inicializa a calculadora na interface gráfica
        SwingUtilities.invokeLater(() -> {
            Calculadora calc = new Calculadora();
            calc.setVisible(true);
        });
    }
}
