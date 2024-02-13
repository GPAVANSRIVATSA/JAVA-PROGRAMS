package mypack;
import java.util.*;
class ArrayListDemonstration
{
	public static void main(String[]args)
	{
		String s;
		Scanner sc=new Scanner(System.in);
		ArrayList<String>al=new ArrayList<String>();
		for(int i=0;i<5;i++)
		{
			s=sc.next();
			al.add(s);
		}
		System.out.println(al);
	}
}