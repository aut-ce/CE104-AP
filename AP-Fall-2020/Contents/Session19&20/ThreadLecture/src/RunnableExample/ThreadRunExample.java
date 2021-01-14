package RunnableExample;

public class ThreadRunExample {

    public static void main(String[] args){
        Thread t1 = new Thread(new HeavyWorkRunnable(), "t1");
        Thread t2 = new Thread(new HeavyWorkRunnable(), "t2");
        
        Thread t3 = new MyThread("t3");
        Thread t4 = new MyThread("t4");
//        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
//        t3.setPriority(Thread.MIN_PRIORITY);
		//The setPriority() method of thread class is used to change the thread's priority.
		//Every thread has a priority which is represented by the integer number between 1 to 10.
		//Thread class provides 3 constant properties:
		//MIN_PRIORITY:It is the minimum priority of a thread.
		//MAX_PRIORITY: It is the maximum priority of a thread.
		//NORM_PRIORITY: It is the default priority of a thread.
		//But NOT IN MULTI-CORE CPU
        System.out.println("Starting Runnable threads");
        t1.start();
        t2.start();
        System.out.println("Runnable Threads has been started");
        System.out.println("Starting MyThreads");
        t3.start();
        t4.start();
        System.out.println("MyThreads has been started");

    }
}