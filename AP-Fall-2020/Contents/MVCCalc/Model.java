import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Stack;

public class Model {
    Stack<Double> numbers;
    Stack<Character> operations;
    Stack<String> text;

    public Model(){
        numbers=new Stack<>();
        operations=new Stack<>();
        text=new Stack<>();
    }
    public Stack<Double> getNumbers(){
        return numbers;
    }

    public Stack<Character> getOperations(){
        return operations;
    }

    public void setNumbers(Stack<Double> numbers) {
        this.numbers = numbers;
    }

    public void setOperations(Stack<Character> operations) {
        this.operations = operations;
    }


}
