package FlatMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
class Student
{
	String sName;
	int id;
	Student(String sName,int id)
	{
		this.sName=sName;
		this.id=id;
	}
}
public class FlatMapDemo3 {
	public static void main(String[]args)
	{
		List<Student>l1=Arrays.asList(new Student("John",100),new Student("Joe",101));
		List<Student>l2=Arrays.asList(new Student("Jim",102),new Student("Steve",103));
		List<List<Student>>l=Arrays.asList(l1,l2);
		List<String>al=new ArrayList<String>();
		al=l.stream().flatMap(x->x.stream().map(o->o.sName)).collect(Collectors.toList());
		System.out.println(al);
		
	}

}
