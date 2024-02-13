package mypack;
import java.util.*;
public class ArrayListDemonstration5 {
	public static void main(String[]args)
	{
		Scanner sc=new Scanner(System.in);
		ArrayList<Integer>al1=new ArrayList<Integer>();
		ArrayList<Integer>al2=new ArrayList<Integer>();
		for(int i=0;i<3;i++)
		{
			al1.add(sc.nextInt());
		}
		for(int i=0;i<3;i++)
		{
			al2.add(sc.nextInt());
		}
		al1.retainAll(al2);
		for(int i:al1)
		{
			System.out.println(i);
		}
	}

}
