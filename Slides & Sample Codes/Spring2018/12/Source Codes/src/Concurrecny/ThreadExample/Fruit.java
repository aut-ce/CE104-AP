package Concurrecny.ThreadExample;

public class Fruit
{
    public static void main(String[] args)
    {
        AppleThread apple = new AppleThread();
        Thread orange = new OrangeThread();
        apple.start();
        //apple.interrupt();

/*
        try {
            apple.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
*/
        orange.start();

//        Thread.sleep(10);
    }
}


