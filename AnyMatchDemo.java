package Sorted;
import java.util.HashSet;
import java.util.Set;

public class AnyMatchDemo {
	public static void main(String[]args)
	{
		Set<String>s=new HashSet<String>();
		s.add("Honda");
		s.add("Hyundai");
		s.add("Audi");
		s.add("BMW");
		boolean b1=s.stream().anyMatch(v->{
			return v.startsWith("H");
		});
		boolean b2=s.stream().allMatch(v->{
			return v.startsWith("H");
		});
		boolean b3=s.stream().noneMatch(v->{
			return v.startsWith("C");
		});
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
	}

}
