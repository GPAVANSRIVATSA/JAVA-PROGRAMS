package mypack;
import java.util.*;
public class StackDemonstration {
	public static void main(String[]args)
	{
		Scanner sc=new Scanner(System.in);
		Stack<Integer>st=new Stack<>();
		for(int i=0;i<5;i++)
		{
			st.push(sc.nextInt());
		}
		System.out.println(st);
	}

}
