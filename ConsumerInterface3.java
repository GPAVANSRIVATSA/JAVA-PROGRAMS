package Consumer;
import java.util.function.Consumer;
public class ConsumerInterface3 {
	public static void main(String[]args)
	{
		Consumer<String>c1=s->System.out.println(s+" is a car brand");
		Consumer<String>c2=s->System.out.println(s+" has different models");
		c1.andThen(c2).accept("Audi");
	}

}
