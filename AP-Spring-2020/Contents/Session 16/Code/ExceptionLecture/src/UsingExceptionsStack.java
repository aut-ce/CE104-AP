public class UsingExceptionsStack {
	public static void main(String[] args) {
		try {
			method1();
		} catch (Exception exception) // exception thrown by throwException
		{
			System.out.printf("%s%n%n", exception.getMessage());
			exception.printStackTrace();

			System.out.printf("%nStack trace from getStackTrace:%n");
			System.out.println("Class\t\t\tFile\t\t\t\tLine\tMethod");

			StackTraceElement[] traceElements = exception.getStackTrace();
			// loop through traceElements to get exception description
			for (StackTraceElement element : traceElements) {
				System.out.printf("%s\t", element.getClassName());
				System.out.printf("%s\t", element.getFileName());
				System.out.printf("%s\t", element.getLineNumber());
				System.out.printf("%s%n", element.getMethodName());
			}

		}
	}

	// call method2; throw exceptions back to main
	public static void method1() throws Exception{
		method2();
	}

	public static void method2() throws Exception{
		method3();
	}

	public static void method3() throws Exception {
		throw new Exception("Exception thrown in method3");
	}
}