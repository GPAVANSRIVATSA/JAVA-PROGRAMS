public class Finally {
public static void main(String[]args)
{
	try
	{
		int a[]=new int[3];
		a[4]=10;
	}
	catch(ArrayIndexOutOfBoundsException e)
	{
		System.out.println(e);
	}
	finally
	{
		System.out.println("Finally Block Executed");
	}
}
}
