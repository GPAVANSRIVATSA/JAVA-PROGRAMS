package Distinct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DistinctDemo {
	public static void main(String[]args)
	{
		List<String>l=Arrays.asList("Audi","Honda","Audi","BMW","Honda","Hyundai");
		List<String>al=new ArrayList<String>();
		List<String>al1=new ArrayList<String>();
		al=l.stream().distinct().collect(Collectors.toList());
		al1=l.stream().limit(3).collect(Collectors.toList());
		long number=l.stream().distinct().count();
		System.out.println(al);
		System.out.println(al1);
		System.out.println(number);
	}

}
