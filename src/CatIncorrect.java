public class CatIncorrect
{
    private String name;
    private int age;

    private String owners_name;

    public CatIncorrect()
    {
        name="Cat";
        age=3;
        owners_name="John";
    }

    public CatIncorrect(String n, int a, String o)
    {
        name=n;
        age=a;
        owners_name=o;
    }

    @Override
    public boolean equals(Object cat)
    {
        return false;
    }

    @Override
    public int hashCode()
    {
        int res = (int)(Math.random()*100)*age;
        for (int i=0; i<Math.random()*5; i++)
        {
            res*=10;
        }
        res/=2;
        for(int i=0; i<owners_name.length(); i++)
        {
            res+=owners_name.charAt(i)%2;
        }
        return res;
    }
}
