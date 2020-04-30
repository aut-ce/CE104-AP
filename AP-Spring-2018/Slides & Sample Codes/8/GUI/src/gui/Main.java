package gui;

public class Main {

    public static void main(String[] args) {

        gui.LoginForm form = new gui.LoginForm("Login");
        form.showGUI();

        LoginFormLM form2 = new LoginFormLM("Login (2)");
        form2.showGUI();

        gui.LoginFormMultiLM form3 = new gui.LoginFormMultiLM("Login (3)");
        form3.showGUI();
    }

}
