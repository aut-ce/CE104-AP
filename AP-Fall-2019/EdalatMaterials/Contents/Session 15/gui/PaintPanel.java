
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class PaintPanel extends JPanel {

    private int stroke;
    private Color chosenColor;
    private StatusObservable observable;
    private ArrayList<PaintEvent> paintEvents;
    private ImageIcon image;

    public PaintPanel() {
        stroke = 16;
        chosenColor = Color.BLACK;
        observable = new StatusObservable();
        paintEvents = new ArrayList<>(4000);
        updateStatus();
        MouseHandler mouseHandler = new MouseHandler();
        KeyHandler keyHandler = new KeyHandler();
        addKeyListener(keyHandler);
        addMouseListener(mouseHandler);
        addMouseMotionListener(mouseHandler);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);

        for (PaintEvent pe: paintEvents) {
            g.setColor(pe.COLOR);
            g.fillRect(pe.X, pe.Y,20,20);
            g.fillOval(pe.X, pe.Y, pe.STROKE, pe.STROKE);
        }
    }

    public void addObserver(Observer obs) {
        observable.addObserver(obs);
    }

    private void updateStatus() {
        String status = String.format("STROKE = %d    COLOR = (R: %d, G: %d, B: %d)    Events = %d",
                stroke, chosenColor.getRed(), chosenColor.getGreen(), chosenColor.getBlue(), paintEvents.size());
        observable.notifyObservers(status);
    }

    private class KeyHandler extends KeyAdapter {
        @Override
        public void keyReleased(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_PLUS:
                case KeyEvent.VK_EQUALS:
                    //System.out.println("'+' released.");
                    if (stroke < 64)
                        stroke += 2;
                    updateStatus();
                    break;

                case KeyEvent.VK_MINUS:
                case KeyEvent.VK_UNDERSCORE:
                    //System.out.println("'-' released.");
                    if (stroke > 4)
                        stroke -= 2;
                    updateStatus();
                    break;

                case KeyEvent.VK_C:
                    //System.out.println("'c' released.");
                    Color selection = JColorChooser.showDialog(PaintPanel.this, "Choose a Color", chosenColor);
                    if (selection != null) {
                        chosenColor = selection;
                        updateStatus();
                    }
                    break;

                case KeyEvent.VK_H:
                case KeyEvent.VK_F1:
                    String helpMessage = "Press/Drag with LEFT Mouse click to draw.\n" +
                                         "Click RIGHT Mouse button to clear all drawings.\n\n" +
                                         "Press 'C' to choose a color.\n" +
                                         "Press +/- to increase/decrease stroke size.\n" +
                                         "Press 'M' to view memory usage stats.\n" +
                                         "Press 'H' to view this help message.";
                    JOptionPane.showMessageDialog(PaintPanel.this, helpMessage, "Help", JOptionPane.PLAIN_MESSAGE);
                    break;

                case KeyEvent.VK_M:
                    Utils.printMemoryStats();
                    break;
            }
        }
    }

    private class MouseHandler extends MouseInputAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            paintEvents.add(new PaintEvent(e.getX() - stroke/2, e.getY() - stroke/2, stroke, chosenColor));
            updateStatus();
            repaint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON3) {
                paintEvents.clear();
                updateStatus();
                repaint();
            }
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            paintEvents.add(new PaintEvent(e.getX() - stroke/2, e.getY() - stroke/2, stroke, chosenColor));
            updateStatus();
            repaint();
        }
    }

    private class StatusObservable extends Observable {
        @Override
        public void notifyObservers(Object arg) {
            setChanged();
            super.notifyObservers(arg);
        }
    }
}

