package gui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LoginFormMultiLM {

    private JFrame loginForm;

    public LoginFormMultiLM(String title) {
        loginForm = new JFrame(title);
        loginForm.setLocationRelativeTo(null);
        loginForm.setMinimumSize(new Dimension(300, 200));
        loginForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        loginForm.setContentPane(panel);

        JLabel label = new JLabel(" Please Enter Your Information ");
        label.setBackground(Color.ORANGE);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setOpaque(true);

        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        label.setBorder(border);

        int labelWidth = label.getPreferredSize().width + 20;
        int labelHeight = label.getPreferredSize().height + 10;
        label.setPreferredSize(new Dimension(labelWidth, labelHeight));

        JLabel unameLabel = new JLabel(" Username : ");
        JTextField unameField = new JTextField("Enter Username ");
        JLabel psswdLabel = new JLabel(" Password : ");
        JPasswordField psswdField = new JPasswordField();

        JPanel fieldsPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        fieldsPanel.add(unameLabel);
        fieldsPanel.add(unameField);
        fieldsPanel.add(psswdLabel);
        fieldsPanel.add(psswdField);

        JButton loginButton = new JButton("Login");
        int buttonWidth = loginButton.getPreferredSize().width;
        int buttonHeight = loginButton.getPreferredSize().height + 10;
        loginButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));

        panel.add(label, BorderLayout.NORTH);
        panel.add(fieldsPanel, BorderLayout.CENTER);
        panel.add(loginButton, BorderLayout.SOUTH);
    }

    public void showGUI() {
        loginForm.setVisible(true);
    }
}
