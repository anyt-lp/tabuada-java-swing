import javax.swing.*;
import java.awt.*;

public class TabuadaSwing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tabuada");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(320, 480);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout(10, 10));

        // Painel de entrada
        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        JLabel label = new JLabel("Número (até 2 dígitos):");
        JTextField campo = new JTextField(5);
        JButton botao = new JButton("Calcular");
        topPanel.add(label);
        topPanel.add(campo);
        topPanel.add(botao);

        // Área de resultado
        JTextArea resultado = new JTextArea();
        resultado.setFont(new Font("Monospaced", Font.PLAIN, 14));
        resultado.setEditable(false);
        resultado.setMargin(new Insets(10, 15, 10, 15));
        JScrollPane scroll = new JScrollPane(resultado);

        botao.addActionListener(e -> {
            try {
                int numero = Integer.parseInt(campo.getText().trim());

                if (numero < -99 || numero > 99) {
                    JOptionPane.showMessageDialog(frame,
                        "Use apenas números com até 2 dígitos!",
                        "Valor inválido", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                StringBuilder sb = new StringBuilder();
                sb.append("=== Tabuada do ").append(numero).append(" ===\n\n");
                for (int i = 1; i <= 10; i++) {
                    sb.append(String.format("%2d  x  %2d  =  %3d%n", numero, i, numero * i));
                }
                resultado.setText(sb.toString());

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame,
                    "Digite apenas números inteiros!",
                    "Erro de entrada", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Enter também calcula
        campo.addActionListener(e -> botao.doClick());

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(scroll, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
