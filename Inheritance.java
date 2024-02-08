class Sample {
void display()
{
	System.out.println("Base class");
}
}
class Child extends Sample
{
	int a=10;
	void cdisplay()
	{
	System.out.println(a);
	}
}
class Inheritance
{
	public static void main(String[]args)
	{
		Child c=new Child();
		c.display();
		c.cdisplay();
	}
}
