public class Overload {
	int add(int a,int b)
	{
		return a+b;
	}
	int add(int a,int b,int c)
	{
		return a+b+c;
	}
	public static void main(String[]args)
	{
		int e,f;
		Overload ol=new Overload();
		e=ol.add(10,20);
		f=ol.add(10, 20,30);
		System.out.println(e);
		System.out.println(f);
	}
}
