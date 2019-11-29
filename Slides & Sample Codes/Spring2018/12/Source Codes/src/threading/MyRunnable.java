package threading;

public class MyRunnable implements Runnable {

    private int mod;
    private String name;

    public MyRunnable(int mod) {
        this.mod = mod;
        name = "run-" + mod;
    }

    @Override
    public void run() {
        for (int i = 2; i <= 40; ++i) {
            if (i % mod == 0)
                System.out.printf("(%s) %d\n", name, i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                System.err.println(ex);
            }
        }
    }
}
