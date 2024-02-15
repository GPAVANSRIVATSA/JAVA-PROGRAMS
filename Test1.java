package demos;
@FunctionalInterface
interface Sample
{
	public void show();
}
public class Test1 {
	public static void main(String[]args)
	{
		Sample ex=()->System.out.println("This is in Example class");
		ex.show();
	}

}
