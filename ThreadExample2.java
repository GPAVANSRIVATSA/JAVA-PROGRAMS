public class ThreadExample2 implements Runnable {
public void run()
{
	System.out.println("Thread is started");
}
public static void main(String[]args)
{
	ThreadExample ob=new ThreadExample();
	Thread t=new Thread(ob);
	t.start();
}
}
