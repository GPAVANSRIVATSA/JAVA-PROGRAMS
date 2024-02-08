interface Abc
{
	void display();
}
class Def implements Abc
{
	public void display()
	{
		System.out.println("Example method");
	}
}
public class Interface {
	public static void main(String[]args)
	{
		Def d=new Def();
		d.display();
	}
}
