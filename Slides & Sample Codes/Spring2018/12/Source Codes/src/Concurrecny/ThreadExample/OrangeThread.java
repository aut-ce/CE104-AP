package Concurrecny.ThreadExample;

class OrangeThread extends Thread {
    public void run() {
        for (int i = 0; i < 6; i++)
            System.out.println("Orange" + i);
    }

}
