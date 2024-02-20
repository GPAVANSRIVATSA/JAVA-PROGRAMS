package FlatMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class FlatMapDemo {
	public static void main(String[]args)
	{
		List<Integer>l1=Arrays.asList(1,2);
		List<Integer>l2=Arrays.asList(3,4);
		List<Integer>l3=Arrays.asList(5,6);
		List<List<Integer>>l=Arrays.asList(l1,l2,l3);
		List<Integer>al=l.stream().flatMap(x->x.stream().map(n->n+10)).collect(Collectors.toList());
		System.out.println(al);
	}

}
