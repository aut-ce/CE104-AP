package gui;

import javax.swing.*;

public class LoginForm {

    private JFrame frame;

    public LoginForm(String title) {
        frame = new JFrame(title);
        frame.setSize(250, 150);
        frame.setLocation(100, 50);
        frame.getContentPane().setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextField unameField = new JTextField("Enter username ...");
        unameField.setSize(200, 30);
        unameField.setLocation(10, 10);

        JPasswordField psswdField = new JPasswordField();
        psswdField.setSize(200, 30);
        psswdField.setLocation(10, 50);

        JButton loginButton = new JButton(" Login ");
        loginButton.setSize(200, 30);
        loginButton.setLocation(10, 90);

        frame.add(unameField);
        frame.add(psswdField);
        frame.add(loginButton);
    }

    public void showGUI() {
        frame.setVisible(true);
    }

}
