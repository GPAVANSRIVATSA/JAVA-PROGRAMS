package mypack;
import java.util.*;
public class ArrayListDemonstration4 {
	public static void main(String[]args)
	{
		Scanner sc=new Scanner(System.in);
		ArrayList<String>al=new ArrayList<String>(5);
		for(int i=0;i<5;i++)
		{
			al.add(sc.next());
		}
		for(int i=0;i<5;i++)
		{
			al.set(0,"Steve");
			al.set(1, "Comic");
			al.set(2, "Mike");
			al.set(3, "Lucas");
			al.set(4, "Snad");
		}
		System.out.println(al.get(4));
		System.out.println(al.get(3));
	}

}
