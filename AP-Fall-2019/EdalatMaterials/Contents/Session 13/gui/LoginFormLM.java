package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LoginFormLM {

    private JFrame frame;

    public LoginFormLM(String title) {
        frame = new JFrame(title);
        frame.setSize(250, 150);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(3, 1, 5, 5));
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(panel);
        
        JTextField unameField = new JTextField("Enter username ...");

        JPasswordField psswdField = new JPasswordField();

        JButton loginButton = new JButton(" Login ");

        frame.add(unameField);
        frame.add(psswdField);
        frame.add(loginButton);
    }

    public void showGUI() {
        frame.setVisible(true);
    }
}
