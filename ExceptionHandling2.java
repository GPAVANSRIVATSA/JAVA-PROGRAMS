public class ExceptionHandling2 {
public static void main(String[]args)
{
	try
	{
		int[]a=new int[5];
		a[5]=10;
	}
	catch(ArithmeticException e)
	{
		System.out.println(e);
	}
	catch(ArrayIndexOutOfBoundsException e)
	{
		System.out.println(e);
	}
	catch(NullPointerException e)
	{
		System.out.println(e);
	}
	finally
	{
		System.out.println("Finally got executed");
	}
}
}
