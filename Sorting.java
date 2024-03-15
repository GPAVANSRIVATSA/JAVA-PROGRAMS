import java.util.*;
public class Sorting
{
    public static void main(String[]args)
    {
        List<Integer>l=Arrays.asList(11,23,16,73,35,56,20);
        int i,j,temp1,temp2;
        for(i=0;i<l.size()-1;i++)
        {
            for(j=i+1;j<l.size();j++)
            {
                if(l.get(i)>l.get(j))
                {
                    temp1=l.get(i);
                    temp2=l.get(j);
                    l.set(i,temp2);
                    l.set(j,temp1);
                }
            }
        }
        System.out.println(l);
    }
}