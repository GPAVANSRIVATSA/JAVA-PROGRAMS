import java.util.Scanner;
public class FactorialRecursive {
	static int fact(int n)
	{
		if(n==0||n==1)
			return 1;
		else
			return n*fact(n-1); 
	}
	public static void main(String[]args)
	{
		Scanner sc = new Scanner(System.in);
		int n,c;
		n=sc.nextInt();
		c=fact(n);
		System.out.println("The factorial of "+n+" is "+c);
	}

}
