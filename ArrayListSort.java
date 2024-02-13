package mypack;
import java.util.*;
public class ArrayListSort {
public static void main(String[]args)
{
	Scanner sc=new Scanner(System.in);
	ArrayList<String>al=new ArrayList<String>();
	for(int i=0;i<5;i++)
	{
		al.add(sc.next());
	}
	Collections.sort(al);
	for(int i=0;i<5;i++)
	{
		System.out.println(al.get(i));
	}
}
}
