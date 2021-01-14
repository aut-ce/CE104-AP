package gui;


import javax.swing.*;

public class Main {

    public static void main(String[] args)  {

        for (UIManager.LookAndFeelInfo info: UIManager.getInstalledLookAndFeels())
            System.out.println(info.getName() + "\t:\t" + info.getClassName());

        //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
       try {
           UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
       }
       catch (ClassNotFoundException| UnsupportedLookAndFeelException| InstantiationException| IllegalAccessException e){


        }
        PaintApplication paint = new PaintApplication();
        paint.show();
    }

}
