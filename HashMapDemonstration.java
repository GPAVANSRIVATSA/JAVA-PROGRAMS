package mypack;
import java.util.*;
public class HashMapDemonstration {
	public static void main(String[]args)
	{
	   HashMap<Integer,String>hm=new HashMap<Integer,String>();
	   for(int i=0;i<5;i++)
	   {
		   hm.put(0, "ABC");
		   hm.put(1, "BCD");
		   hm.put(2, "DEF");
		   hm.put(3, "EFG");
		   hm.put(4, "HIJ");
	   }
	   for(int i=0;i<5;i++)
	   {
		   System.out.println(hm.get(i));
	   }
	}

}
