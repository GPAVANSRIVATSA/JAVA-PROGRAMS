package Consumer;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.ArrayList;
class Employee
{
	public String empName;
	public int salary;
	Employee(String name,int sal)
	{
		empName=name;
		salary=sal;
	}
}
public class ConsumerInterface2 {
	public static void main(String[]args)
	{
		ArrayList<Employee>al=new ArrayList<Employee>();
		al.add(new Employee("Steve",60000));
		al.add(new Employee("Ope",45000));
		al.add(new Employee("Woe",52000));
		Predicate<Integer>p=b->b>5000;
		Function<Employee,Integer>f=o->(o.salary*10)/100;
		Consumer<Employee>c=o->
		{
			System.out.println("The name of the employee is "+o.empName+" and the salary is "+o.salary);
		};
		for(Employee o:al)
		{
			int bonus=f.apply(o);
			if(p.test(bonus))
			{
				c.accept(o);
			}
		}
	}

}
