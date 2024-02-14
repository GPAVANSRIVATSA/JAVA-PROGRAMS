public class ThreadExample3 extends Thread {
public void run()
{
	for(int i=1;i<5;i++)
	{
		try
		{
			Thread.sleep(5000);
		}
		catch(InterruptedException e)
		{
			System.out.println(e);
		}
		System.out.println(i);
	}
}
public static void main(String[]args)
{
	ThreadExample3 t1=new ThreadExample3();
	ThreadExample3 t2=new ThreadExample3();
	t1.start();
	t2.start();
}
}
