package Distinct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
public class DistinctDemo2 {
	public static void main(String[]args)
	{
		List<Integer>l=Arrays.asList(10,15,20,25,30,35,40,45,50);
		List<Integer>al=new ArrayList<Integer>();
		al=l.stream().filter(n->n%2==0).collect(Collectors.toList());
		long number;
		number=al.stream().count();
		Optional<Integer>min=l.stream().min((n1,n2)->{
			return (n1).compareTo(n2);
		});
		System.out.println(number);
		System.out.println(min.get());
		
	}

}
