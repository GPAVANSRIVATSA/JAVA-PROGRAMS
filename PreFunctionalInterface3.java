package demos;
import java.util.function.Predicate;
public class PreFunctionalInterface3 {
	public static void main(String[]args)
	{
		Predicate<Integer>p1=i->(i%2==0);
		Predicate<Integer>p2=i->(i>25);
		int[]a= {10,15,20,25,30,35,40,45,50};
		for(int i:a)
		{
			if(p1.test(i) && p2.test(i))//if(p1. and (p2).test(i))
			{
				System.out.println(i);
			}
		}
	}

}
