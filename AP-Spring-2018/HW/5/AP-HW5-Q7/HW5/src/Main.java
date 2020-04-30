import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        SimplePersonQueue spq = new SimplePersonQueue();

        if (spq instanceof Queue) {
            System.out.println("LinkedPersonQueue is an Queue");
        }

        if (spq.peek() == null) {
            System.out.println("Queue is empty");
        }

		spq.add(new Person("Seyed", "Ahmadpanah"));
        spq.add(new Person("Parham", "Alvani"));

        if (spq.element().equals(new Person("Parham", "Alvani"))) {
            System.out.println("Parham is on the head of queue");
        }

        spq.peek();
		spq.peek();

        if (spq.size() == 0) {
            System.out.println("Queue is empty");
        }
		
		//USE OTHER METHODS OF THE SimplePersonQueue CLASS TO TEST ALL UNITS OF YOUR CODE...
    }
}
