package demos;
@FunctionalInterface
interface Sample
{
	public void show(String car,String model);
}
public class Test2
{
	public static void main(String[]args)
	{
		Sample ex=(car,model)->System.out.println("The car name is "+car+" and the model is "+model);
		ex.show("Audi","Q3");
	}
}