package Map;
import java.util.*;
import java.util.stream.Collectors;
public class MapDemo3 {
	public static void main(String[]args)
	{
		List<Integer>l=Arrays.asList(10,15,20,25,30);
		List<Integer>al=new ArrayList<Integer>();
		al=l.stream().map(i->i*3).collect(Collectors.toList());
		System.out.println(al);
	}

}
