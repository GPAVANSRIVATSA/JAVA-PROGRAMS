package ParallelStreams;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Student
{
	public String sName;
	public int score;
	
	Student(String sName,int score)
	{
		this.sName=sName;
		this.score=score;
	}
}
public class ParallelStreamsDemo {
	public static void main(String[]args)
	{
		List<Student>l=Arrays.asList(new Student("John",80),new Student("Adam",60),new Student("Jim",45),new Student("Joe",30));
		List<Student>al=new ArrayList<Student>();
		al=l.parallelStream().filter(x->x.score>50).limit(1).collect(Collectors.toList());
		for(Student o:al)
		{
			System.out.println("The name is "+o.sName+" and the score is "+o.score);
		}
		
	}

}
