package Sorted;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
public class SortDemo {
	public static void main(String[]args)
	{
		List<Integer>l=Arrays.asList(10,45,20,50,25,15,30,40,35);
		List<Integer>al=new ArrayList<Integer>();
		List<Integer>al1=new ArrayList<Integer>();
		al=l.stream().sorted().collect(Collectors.toList());
		al1=l.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(al);
		System.out.println(al1);
	}

}
