package Map;
import java.util.*;
import java.util.stream.Collectors;
public class MapDemo2 {
	public static void main(String[]args)
	{
		List<String>l=Arrays.asList("joe","widen","steve","lucas");
		List<Integer>al=new ArrayList<Integer>();
		al=l.stream().map(s->s.length()).collect(Collectors.toList());
		System.out.println(al);
		
	}

}
