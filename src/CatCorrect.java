public class CatCorrect {
    private String name;
    private int age;

    private String owners_name;

    public CatCorrect()
    {
        name="Cat";
        age=3;
        owners_name="John";
    }

    public CatCorrect(String n, int a, String o)
    {
        name=n;
        age=a;
        owners_name=o;
    }

    public boolean equals(CatCorrect cat)
    {
        return (name.equals(cat.name)) && (age==cat.age) && (owners_name.equals(cat.owners_name));
    }

    public int hashCode()
    {
        int res = age*17393;
        res+=(name.hashCode()*name.hashCode())*183;
        res-=owners_name.hashCode()*130;
        res+=241215117;
        return res;
    }
}
