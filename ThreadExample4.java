public class ThreadExample4 extends Thread{
	public void run()
	{
		System.out.println("Thread t1 is getting executed");
	}
	public static void main(String[]args)
	{
		ThreadExample4 t1=new ThreadExample4();
		ThreadExample4 t2=new ThreadExample4();
		ThreadExample4 t3=new ThreadExample4();
		System.out.println(t1.getPriority());
		System.out.println(t2.getPriority());
		System.out.println(t3.getPriority());
		t1.setPriority(1);
		t2.setPriority(2);
		t3.setPriority(3);
		System.out.println(t1.getPriority());
		t1.start();
		
	}

}
