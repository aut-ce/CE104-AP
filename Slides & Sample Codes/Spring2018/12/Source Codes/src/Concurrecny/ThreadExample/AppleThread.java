package Concurrecny.ThreadExample;

class AppleThread extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Apple" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
//                e.printStackTrace();
                System.err.println("apple is interrupted!");
            }
        }
    }
}
