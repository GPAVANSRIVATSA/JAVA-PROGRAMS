package mypack;

public class SingletonDemonstration {
		private static SingletonDemonstration objectEx;
		private SingletonDemonstration(){};
		public static SingletonDemonstration getInstance()
		{
			if(objectEx==null)
			{
				objectEx=new SingletonDemonstration();
			}
			return objectEx;
		}
}
