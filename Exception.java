public class Exception {
	public static void main(String[]args)
	{
		try
		{
			int a=50/0;
		}
		catch(ArithmeticException e)
		{
			System.out.println(e);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println(e);
		}
		System.out.println("Program executed");
	}

}
