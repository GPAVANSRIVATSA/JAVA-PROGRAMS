class Demo
{
	private Demo()
	{
		
	}
	public int a=10;
}
public class PrivateAccessModifier2 {
	public static void main(String[]args)
	{
	Demo d = new Demo();
	System.out.println(d.a);
	}
}
