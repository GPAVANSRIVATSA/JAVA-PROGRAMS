public class ExceptionHandling {
public static void main(String[]args)
{
	try
	{
		int a=10,b=0,c;
		c=a/b;
		System.out.println("Value of c is "+c);
	}
	catch(ArithmeticException e)
	{
		System.out.println(e);
	}
	finally
	{
		System.out.println("Finally block got executed");
	}
}
}
