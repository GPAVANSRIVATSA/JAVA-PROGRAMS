package demos;
@FunctionalInterface
interface Car
{
	public void show();
}
class Audi implements Car
{
	public void show()
	{
		System.out.println("It is Audi class");
	}
}
public class Test {
	public static void main(String[]args)
	{
		Car a=new Audi();
		a.show();
	}

}
