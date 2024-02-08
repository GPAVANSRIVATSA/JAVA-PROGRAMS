abstract class Sample
{
	abstract void display();
}
class Example extends Sample
{
	void display()
	{
		System.out.println("Method body created");
	}
}
public class Abstraction {
	public static void main(String[]args)
	{
		Example ex=new Example();
		ex.display();
	}
}