package Sorted;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class FindAny {
	public static void main(String[]args)
	{
		Set<String>s=new HashSet<String>();
		s.add("Audi");
		s.add("BMW");
		s.add("Honda");
		s.add("Hyundai");
		Optional<String>o1=s.stream().findAny();
		Optional<String>o2=s.stream().findFirst();
		System.out.println(o1.get());
		System.out.println(o2.get());
	}

}
