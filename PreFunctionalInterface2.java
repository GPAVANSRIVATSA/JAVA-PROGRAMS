package demos;
import java.util.function.Predicate;
import java.util.ArrayList;
class Automobile
{
	public String name;
	public String model;
	Automobile(String name,String model)
	{
		this.name=name;
		this.model=model;
	}
}
public class PreFunctionalInterface2 {
	public static void main(String[]args)
	{
	Predicate<Automobile>p=o->((o.name).length()> 4 && (o.model).length()>4);
	ArrayList<Automobile>al=new ArrayList<Automobile>();
	al.add(new Automobile("Audi","Q3"));
	al.add(new Automobile("BMW","X3"));
	al.add(new Automobile("Honda","City"));
	al.add(new Automobile("Hyundai","Creta"));
	for(int i=0;i<al.size();i++)
	{
		if(p.test(al.get(i)))
		{
			System.out.println("The car name is "+al.get(i).name+" and then model is "+al.get(i).model);
		}
	}
	}

}
