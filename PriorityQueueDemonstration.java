package mypack;
import java.util.*;
public class PriorityQueueDemonstration {
	public static void main(String[]args)
	{
		Scanner sc=new Scanner(System.in);
		PriorityQueue<Integer>pq=new PriorityQueue<Integer>();
		for(int i=0;i<5;i++)
		{
			pq.add(sc.nextInt());
		}
		Iterator it=pq.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
