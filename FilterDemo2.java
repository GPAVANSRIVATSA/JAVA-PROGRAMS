package StreamsDemo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class FilterDemo2 {
	public static void main(String[]args)
	{
		List<String>l=Arrays.asList("Joe","Steve","Wiom","Lucas","Sanndy");
		List<String>al=new ArrayList<String>();
		al=l.stream().filter(s->(s.length()>4&&s.length()<6)).collect(Collectors.toList());
		System.out.println(al);
	}

}
