public class ExceptionHandling3 {
	public static void divide()throws ArithmeticException 
	{
		throw new ArithmeticException("Divide by zero is not possible");
	}
	public static void main(String[]args)
	{
		divide();
	}

}
