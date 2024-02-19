package Map;
import java.util.*;
import java.util.stream.Collectors;
public class MapDemo {
	public static void main(String[]args)
	{
		List<String>l=Arrays.asList("joe","widen","steve","lucas");
		List<String>al=new ArrayList<String>();
		al=l.stream().map(s->s.toUpperCase()).collect(Collectors.toList());
		System.out.println(al);
	}

}