import javax.management.StringValueExp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Optional;

/**
 * this class present a Calculator GUI
 *
 * @author Narges Salehi
 */
public class View {
    Controller controller;
    //creat a new JFrame for calculator frame
    JFrame window;
    //creat a new JPanel for standard calculator
    JPanel p1 = new JPanel();
    //creat a new JPanel for scientific calculator
    JPanel p2 = new JPanel();
    //creat a tab to add panels
    JTabbedPane Switch = new JTabbedPane();
    //creat a text area for showing result
    JTextArea display1 = new JTextArea();
    //Buttons
    JButton openBot = new JButton("(");
    JButton closeBot = new JButton(")");
    JButton remBot = new JButton("%");
    JButton clearBot = new JButton("C");
    JButton seven = new JButton("7");
    JButton eight = new JButton("8");
    JButton nine = new JButton("9");
    JButton divBot = new JButton("/");
    JButton four = new JButton("4");
    JButton five = new JButton("5");
    JButton six = new JButton("6");
    JButton mulBot = new JButton("*");
    JButton one = new JButton("1");
    JButton two = new JButton("2");
    JButton three = new JButton("3");
    JButton subBot = new JButton("-");
    JButton zeroBtn = new JButton("0");
    JButton dot = new JButton(".");
    JButton equalBtn = new JButton("=");
    JButton sumBtn = new JButton("+");
    //extra button of scientific calculator
    JButton eOrEuler = new JButton("e");
    JButton shift = new JButton("Shift");
    JButton sinOrCos = new JButton("sin-cos");
    JButton tanOrCot = new JButton("tan-cot");
    JButton expOrLog = new JButton("exp-log");
    JButton openBot2 = new JButton("(");
    JButton closeBot2 = new JButton(")");
    JButton remBot2 = new JButton("%");
    JButton clearBot2 = new JButton("C");
    JButton seven2 = new JButton("7");
    JButton eight2 = new JButton("8");
    JButton nine2 = new JButton("9");
    JButton divBot2 = new JButton("/");
    JButton four2 = new JButton("4");
    JButton five2 = new JButton("5");
    JButton six2 = new JButton("6");
    JButton mulBot2 = new JButton("*");
    JButton one2 = new JButton("1");
    JButton two2 = new JButton("2");
    JButton three2 = new JButton("3");
    JButton subBot2 = new JButton("-");
    JButton zeroBtn2 = new JButton("0");
    JButton equalBtn2 = new JButton("=");
    JButton sumBtn2 = new JButton("+");
    JButton dot2 = new JButton(".");

    /**
     * creat a new Calculator
     */
    public View() {
        super();
        //new JFrame
        window = new JFrame("AUTCalculator");
        //set size for frame
        window.setSize(400, 500);
        //set location of frame in your screen
        window.setLocation(550, 250);
        //make window not resizable
        window.setResizable(false);
        //set a layout for calculator
        window.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenu = new JMenu("File");
        JMenu jMenu1 = new JMenu("Edit");
        JMenuItem jMenuItem = new JMenuItem("Exit");
        JMenuItem jMenuItem1=new JMenuItem("Copy");
        jMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.ALT_MASK));
        jMenuItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.SHIFT_MASK));
        jMenu.add(jMenuItem);
        jMenu.add(jMenuItem1);
        jMenuBar.add(jMenu);
        jMenuBar.add(jMenu1);
        window.add(jMenuBar, gbc);
        //make window visible
        window.setVisible(true);
        //set a layout for panel
        p1.setLayout(new GridLayout(5, 4));
        //set a layout for panel
        p2.setLayout(new GridLayout(5, 5));
        //set bounds of tab
        Switch.setBounds(0, 100, 400, 380);
        //add panels to tab
        Switch.add("Standard", p1);
        Switch.add("Scientific", p2);
        //make not possible to write in text area
        display1.setEditable(false);
        display1.setPreferredSize(new Dimension(0, 10));
        display1.setToolTipText("Display");
        //set font size and type of words in text area
        display1.setFont(new Font("Arial", Font.BOLD, 14));
        //make scroll for both horizontal and vertical
        //creat a scroll for text area
        JScrollPane scrollPane = new JScrollPane(display1);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //add scroll to frame
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        window.getContentPane().add(scrollPane, gbc);
        //creating and adding buttons to each calculator
        ButtonClickHandler handler = new ButtonClickHandler();
        ButtonKeyboardHandler handler1 = new ButtonKeyboardHandler();
        p1.add(openBot);
        openBot.addActionListener(handler);
        openBot.setToolTipText("Parentheses");
        p1.add(closeBot);
        closeBot.setToolTipText("Parentheses");
        closeBot.addActionListener(handler);
        p1.add(remBot);
        remBot.setToolTipText("Remaining");
        remBot.addActionListener(handler);
        p1.add(clearBot);
        clearBot.setToolTipText("Clear");
        clearBot.addActionListener(handler);
        p1.add(seven);
        seven.setToolTipText("Number 7");
        seven.addActionListener(handler);
        p1.add(eight);
        eight.setToolTipText("Number 8");
        eight.addActionListener(handler);
        p1.add(nine);
        nine.setToolTipText("Number 9");
        nine.addActionListener(handler);
        p1.add(divBot);
        divBot.setToolTipText("Division");
        divBot.addActionListener(handler);
        p1.add(four);
        four.setToolTipText("Number 4");
        four.addActionListener(handler);
        p1.add(five);
        five.setToolTipText("number 5");
        five.addActionListener(handler);
        p1.add(six);
        six.setToolTipText("Number 6");
        six.addActionListener(handler);
        p1.add(mulBot);
        mulBot.setToolTipText("Multiplier");
        mulBot.addActionListener(handler);
        p1.add(one);
        one.setToolTipText("Number 1");
        one.addActionListener(handler);
        p1.add(two);
        two.setToolTipText("Number 2");
        two.addActionListener(handler);
        p1.add(three);
        three.setToolTipText("Number 3");
        three.addActionListener(handler);
        p1.add(subBot);
        subBot.setToolTipText("Subtraction");
        subBot.addActionListener(handler);
        p1.add(zeroBtn);
        zeroBtn.setToolTipText("Number 0");
        zeroBtn.addActionListener(handler);
        zeroBtn.addKeyListener(handler1);
        p1.add(dot);
        dot.setToolTipText("Dot");
        dot.addActionListener(handler);
        p1.add(equalBtn);
        equalBtn.setToolTipText("Equal");
        equalBtn.addActionListener(handler);
        p1.add(sumBtn);
        sumBtn.setToolTipText("Sub");
        sumBtn.addActionListener(handler);
        //adding and creating buttons for scientific calculator
        p2.add(shift);
        shift.setToolTipText("Shift");
        shift.addActionListener(handler);
        p2.add(openBot2);
        openBot2.addActionListener(handler);
        p2.add(closeBot2);
        closeBot2.addActionListener(handler);
        p2.add(remBot2);
        remBot2.addActionListener(handler);
        p2.add(clearBot2);
        clearBot2.addActionListener(handler);
        p2.add(eOrEuler);
        eOrEuler.addActionListener(handler);
        p2.add(seven2);
        seven2.addActionListener(handler);
        p2.add(eight2);
        eight2.addActionListener(handler);
        p2.add(nine2);
        nine2.addActionListener(handler);
        p2.add(divBot2);
        divBot2.addActionListener(handler);
        p2.add(tanOrCot);
        tanOrCot.addActionListener(handler);
        p2.add(four2);
        four2.addActionListener(handler);
        p2.add(five2);
        five2.addActionListener(handler);
        p2.add(six2);
        six2.addActionListener(handler);
        p2.add(mulBot2);
        mulBot2.addActionListener(handler);
        p2.add(expOrLog);
        expOrLog.addActionListener(handler);
        p2.add(one2);
        one2.addActionListener(handler);
        p2.add(two2);
        two2.addActionListener(handler);
        p2.add(three2);
        three2.addActionListener(handler);
        p2.add(subBot2);
        subBot2.addActionListener(handler);
        p2.add(sinOrCos);
        sinOrCos.addActionListener(handler);
        p2.add(zeroBtn2);
        zeroBtn2.addActionListener(handler);
        p2.add(dot2);
        dot2.addActionListener(handler);
        p2.add(equalBtn2);
        equalBtn2.addActionListener(handler);
        p2.add(sumBtn2);
        sumBtn2.addActionListener(handler);
        //add tab to frame
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 7;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        window.add(Switch, gbc);
    }
    
    public void setController(Controller c) {
    	this.controller=c;
    }

    private class ButtonClickHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource().equals(one) || e.getSource().equals(one2)) {
                
            	controller.addNum(1);
            	display1.setText(controller.prepareTextOnScreen());
            } else if (e.getSource().equals(two) || e.getSource().equals(two2)) {
            	controller.addNum(2);
            	display1.setText(controller.prepareTextOnScreen());
            } else if (true) {//numbers.size() != 0) {
                if (e.getSource().equals(sumBtn) || e.getSource().equals(sumBtn2)) {
                	controller.addOprator('+');
                	display1.setText(controller.prepareTextOnScreen());

                } else if (e.getSource().equals(equalBtn) || e.getSource().equals(equalBtn2)) {

                	display1.setText(controller.prepareTextOnScreen()+"="+controller.calculateResult());
                }
            }
        }
    }
    private class jMenuHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
    private class ButtonKeyboardHandler implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }


}