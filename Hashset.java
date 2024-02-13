package mypack;
import java.util.*;
public class Hashset {
public static void main(String[]args)
{
	HashSet<Integer> hs=new HashSet();
	Scanner sc=new Scanner(System.in);
	for(int i=0;i<5;i++)
	{
		hs.add(sc.nextInt());
	}
	Iterator it=hs.iterator();
	while(it.hasNext()) {
		System.out.println(it.next());
	}
	
}
}
