class Car
{
	private int a=10;
	private void output()
	{
		System.out.println("Method executed");
	}
}
public class PrivateAcessModifier {
	public static void main(String[]args)
	{
	Car c=new Car();
	System.out.println(c.a);
	c.output();
	}
}
