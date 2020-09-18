package gui;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class PaintApplication implements Observer {

    private JFrame frame;
    private JLabel statusBar;
    private PaintPanel paintPanel;

    public PaintApplication() {
        frame = new JFrame("Paint Application");
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setMinimumSize(new Dimension(400, 300));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPanel = new JPanel(new BorderLayout(3, 3));
        contentPanel.setBorder(new EmptyBorder(3, 3, 3, 3));
        frame.setContentPane(contentPanel);

        paintPanel = new PaintPanel();

        statusBar = new JLabel("Press H for help.");
        statusBar.setFocusable(false);
        statusBar.setFont(statusBar.getFont().deriveFont(Font.BOLD));
        Dimension statusSize = statusBar.getPreferredSize();
        statusSize.height += 15;
        statusBar.setPreferredSize(statusSize);

        frame.add(paintPanel, BorderLayout.CENTER);
        frame.add(statusBar, BorderLayout.SOUTH);
    }

    public void show() {
        frame.setVisible(true);
        paintPanel.addObserver(this);
        paintPanel.requestFocusInWindow();
        //Requests that this Component get the input focus, if thisComponent's top-level ancestor is already the focusedWindow. 
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg == null)
            return;
        String status = (String) arg;
        statusBar.setText(status);
    }
}
