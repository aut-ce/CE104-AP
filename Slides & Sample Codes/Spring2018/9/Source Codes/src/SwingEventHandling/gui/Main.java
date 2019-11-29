package SwingEventHandling.gui;

import javax.swing.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {

        for (UIManager.LookAndFeelInfo info: UIManager.getInstalledLookAndFeels())
            System.out.println(info.getName() + "\t:\t" + info.getClassName());

        //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

        LoginFormWithEventHandling login = new LoginFormWithEventHandling("My Login");
        login.showGUI();
    }

}
