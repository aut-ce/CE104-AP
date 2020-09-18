import java.awt.*;

public class Controller {
	private View view;
	private Model model;

	public Controller(Model m, View v) {
		this.model = m;
		this.view = v;
		initView();
	}

	public void addOprator(char o) {
		model.operations.add(o);
	}

	public void addNum(double d) {
		model.numbers.add(d);
	}
	
	public void addText(String s) {
		model.text.add(s);
	}
	
	private void initView() {
		view.setController(this);
	}
	public double calculateResult() {
		while (!model.operations.isEmpty()) {
			double last = model.numbers.pop();
			double first = model.numbers.pop();
			char op = model.operations.pop();
			double result = 0;
			switch (op) {
			case '+':
				result = first + last;
				break;
			case '-':
				result = first - last;
				break;
			}
			model.numbers.push(result);
		}
		return model.numbers.pop();
	}
	public String prepareTextOnScreen() {
		return "";
	}
}
