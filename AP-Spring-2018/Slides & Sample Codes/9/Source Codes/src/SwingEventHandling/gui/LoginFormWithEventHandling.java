package SwingEventHandling.gui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFormWithEventHandling {

    private JFrame frame;
    private JButton loginButton;
    private JTextField unameField;
    private JPasswordField psswdField;

    public LoginFormWithEventHandling(String title) {
        frame = new JFrame(title);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(panel);

        JLabel label = new JLabel(" Please Enter Your Information ");
        label.setBackground(Color.ORANGE);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setOpaque(true);

        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        label.setBorder(border);

        int labelWidth = label.getPreferredSize().width;
        int labelHeight = label.getPreferredSize().height + 10;
        label.setPreferredSize(new Dimension(labelWidth, labelHeight));

        LoginHandler loginHandler = new LoginHandler();

        JLabel unameLabel = new JLabel(" Username : ");
        unameField = new JTextField("Enter Username ...");
        unameField.addActionListener(loginHandler);
        JLabel psswdLabel = new JLabel(" Password : ");
        psswdField = new JPasswordField();
        psswdField.addActionListener(loginHandler);

        JPanel fieldsPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        fieldsPanel.add(unameLabel);
        fieldsPanel.add(unameField);
        fieldsPanel.add(psswdLabel);
        fieldsPanel.add(psswdField);

        loginButton = new JButton("Login");
        loginButton.addActionListener(loginHandler);
        int buttonWidth = loginButton.getPreferredSize().width;
        int buttonHeight = loginButton.getPreferredSize().height + 10;
        loginButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));

        panel.add(label, BorderLayout.NORTH);
        panel.add(fieldsPanel, BorderLayout.CENTER);
        panel.add(loginButton, BorderLayout.SOUTH);
    }

    /**
     * Show it!
     */
    public void showGUI() {
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * An ActionListener for handling ActionEvents!
     */
    private class LoginHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(loginButton)) {
                System.out.println("SOURCE: Login Button");
            } else if (e.getSource().equals(unameField)) {
                System.out.println("SOURCE: User Field");
            } else if (e.getSource().equals(psswdField)) {
                System.out.println("SOURCE: Password Field");
            }

            String user = unameField.getText();
            String pwd = new String(psswdField.getPassword());
            if (user.equals(pwd)) {
                JOptionPane.showMessageDialog(frame, "MATCH! :)", "Result", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "MISMATCH! :(", "Result", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
