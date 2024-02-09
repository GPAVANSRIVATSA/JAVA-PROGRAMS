package pack1;

class Demo {
	int a=10;
	void workFlow()
	{
		System.out.println("In Default class");
	}
}
class Default
{
	Demo d=new Demo();
	System.out.println(d.a);
	d.workFlow();
}
