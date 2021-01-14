package ThreadExample;

public class Fruit {
    public static void main(String[] args) {
        AppleThread apple = new AppleThread();
        Thread orange = new OrangeThread();
        apple.start();
//        apple.interrupt();
        //interrupt() method : 
		//If any thread is in sleeping or waiting state then using interrupt() method,
		//we can interrupt the execution of that thread by showing InterruptedException.
		//A thread which is in the sleeping or waiting state can be interrupted with the help
		//of interrupt() method of Thread class.


//        try {
//            apple.join(); 
//            // If t is a Thread object whose thread is currently executing, 
//            //then t. join() will make sure that t is terminated before the 
//            //next instruction is executed by the program.
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        orange.start();

//        Thread.sleep(10);
    }
}


