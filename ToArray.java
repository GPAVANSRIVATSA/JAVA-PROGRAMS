package Distinct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class ToArray {
	public static void main(String[]args)
	{
		List<Integer>l=Arrays.asList(1,2,3,4,5);
		Object[]arr=l.stream().toArray();
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
	}

}
