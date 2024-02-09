class Wave
{
	public int a=10;
	public void display()
	{
		System.out.println("The value of a is: "+a);
	}
}
class PublicAccessModifier extends Wave
{
	public static void main(String[]args)
	{
		PublicAccessModifier pa = new PublicAccessModifier();
		System.out.println(pa.a);
		pa.display();
	}
}