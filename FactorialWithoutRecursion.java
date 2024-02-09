import java.util.Scanner;
public class FactorialWithoutRecursion {
	public static void main(String[]args)
	{
		Scanner sc = new Scanner(System.in);
		int i,n,pro=1;
		n=sc.nextInt();
		for(i=1;i<=n;i++)
		{
			pro=pro*i;
		}
		System.out.println("The factorial of "+n+" is "+pro);
	}

}
