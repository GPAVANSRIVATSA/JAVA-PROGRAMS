public class Sample
{
	void display()
	{
		System.out.println("Its Base class");
	}
}
public class Child extends Sample
{
	void display()
	{
		System.out.println("Its child class");
	}
}
public class Override {
	Child c=new Child();
	c.display();
}
