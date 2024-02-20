package FlatMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapDemo2 {
	public static void main(String[]args)
	{
		List<String>l1=Arrays.asList("Joe","Jow");
		List<String>l2=Arrays.asList("Widen","John");
		List<String>l3=Arrays.asList("Steve","Lucas");
		List<List<String>>l=Arrays.asList(l1,l2,l3);
		List<String>al=new ArrayList<String>();
		al=l.stream().flatMap(x->x.stream()).collect(Collectors.toList());
		System.out.println(al);
	}
	

}
