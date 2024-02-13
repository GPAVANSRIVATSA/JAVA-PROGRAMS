package mypack;
import java.util.*;
class Car
{
	public String company;
	public String model;
	public Car(String company,String model)
	{
		this.company=company;
		this.model=model;
	}
}
public class ArrayListDemonstration6 {
	public static void main(String[]args)
	{
		Car c1=new Car("Audi","Q3");
		Car c2=new Car("BMW","M6");
		ArrayList<Car>al=new ArrayList<Car>();
		al.add(c1);
		al.add(c2);
		for(Car v:al)
		System.out.println("The car comapny is "+v.company+" and the model is "+v.model);
	}
	

}
