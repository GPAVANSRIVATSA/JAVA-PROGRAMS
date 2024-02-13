package mypack;
import java.util.*;
public class ArrayListDemonstration3 {
	public static void main(String[]args)
	{
		Scanner sc=new Scanner(System.in);
		ArrayList<Integer>al=new ArrayList<Integer>();
		for(int i=0;i<5;i++)
		{
			al.add(sc.nextInt());
		}
		for(int j:al)
		{
			System.out.println(j);
		}
	}
	

}
