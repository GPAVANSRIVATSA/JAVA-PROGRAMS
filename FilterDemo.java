package StreamsDemo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class FilterDemo {
	public static void main(String[]args)
	{
		List<Integer>l=Arrays.asList(10,15,20,25,30,35,40);
		List<Integer>al=new ArrayList<Integer>();
		al=l.stream().filter(n->(n%2==0)).collect(Collectors.toList());
		System.out.println(al);
		//l.stream().filter(n->n%2==0).forEach(System.out::println);
	}

}
