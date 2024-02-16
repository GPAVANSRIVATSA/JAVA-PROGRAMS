package demos;
import java.util.function.Predicate;
public class PreFunctionalInterface {
	public static void main(String[]args)
	{
		Predicate<String>p=s->(s.length()>4);
		String[]Cars= {"Audi","BMW","Honda","Hyundai"};
		for(String name:Cars)
		{
			if(p.test(name))
			{
				System.out.println(name);
			}
		}
	}
}
