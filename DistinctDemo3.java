package Distinct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
public class DistinctDemo3 {
	public static void main(String[]args)
	{
		List<String>l=Arrays.asList("A","B","C","D");
		Optional<String>o=l.stream().reduce((val1,val2)->
		{
			return val1+val2;
		});
		System.out.println(o.get());
	}

}
