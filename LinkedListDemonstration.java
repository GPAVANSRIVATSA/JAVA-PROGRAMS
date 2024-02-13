package mypack;
import  java.util.*;
public class LinkedListDemonstration {
	public static void main(String[]args)
	{
		Scanner sc=new Scanner(System.in);
		LinkedList<String>ll=new LinkedList<String>();
		for(int i=0;i<5;i++)
		{
			ll.add(sc.next());
		}
		for(int i=0;i<ll.size();i++)
		{
			System.out.println(ll.get(i));
		}
		Iterator<String>it=ll.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
