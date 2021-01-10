package ThreadExample;

class OrangeThread extends Thread {
	public void run() {
		for (int i = 0; i < 6; i++) {
			System.out.println("Orange" + i);
			try {
				Thread.sleep(0);
			} catch (InterruptedException e) {
				System.err.println("orange is interrupted!");
			}
		}
	}

}
