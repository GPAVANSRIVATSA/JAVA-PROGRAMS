package demos;
@FunctionalInterface
interface Simple
{
	public String show(String car,String model);
}
public class Test3 {
	public static void main(String[]args)
	{
		Simple ex=(car,model)->{System.out.println("The car name is "+car+" and the model is "+model);return("The car is available in India");};
		System.out.println(ex.show("Audi","Q3"));
	}

}
