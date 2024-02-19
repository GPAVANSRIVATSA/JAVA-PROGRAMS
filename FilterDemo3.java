package StreamsDemo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class FilterDemo3 {
	public static void main(String[]args)
	{
		List<String>l=Arrays.asList("Joe",null,"Steve",null,"Lucas");
		List<String>al=new ArrayList<String>();
		al=l.stream().filter(s->s!=null).collect(Collectors.toList());
		System.out.println(al);
	}

}
