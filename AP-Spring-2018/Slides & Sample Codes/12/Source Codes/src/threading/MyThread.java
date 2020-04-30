package threading;

public class MyThread extends Thread {

    private int mod;

    public MyThread(int mod) {
        super("mod-" + mod);
        this.mod = mod;
    }

    @Override
    public void run() {
        for (int i = 2; i <= 40; ++i) {
            if (i % mod == 0)
                System.out.printf("(%s) %d\n", getName(), i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                System.err.println(ex);
            }
        }
    }
}
