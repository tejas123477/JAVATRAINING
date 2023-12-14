public class Adder {


    private String geek;

    final int a = 10;

    void show() {
        System.out.println("a = " + a);
        //a = 20;	//Error due to final variable cann't be modified
    }

    public Adder()
    {
        // Default Constructor
        // initializing Instance Variable
        this.geek = "Shubham Jain";
    }


    public void output()
    {
        int var = 10;

        // This variable is local to this main method only
        System.out.println("Local Variable: " + var);
    }

    Integer x1,y1;

    Float x2,y2;


    Integer add1(Integer x1,Integer y1)
    {
        return x1+y1;
    }

    Float add2(Float x2,Float y2)
    {
        return x2+y2;
    }

    public Character ans(Character c1, Character c2)
    {
        return (char) (c1+c2);
    }

//    public static Integer add(Integer a,Integer b)
//    {
//        return a+b;
//    }
//
//    public static Float adding(float x,float y)
//    {
//        return x+y;
//    }
//
//    public static boolean ans(Integer x,Integer y)
//    {
//        return x>y;
//    }

    public static void main(String[] args)
    {

        Adder ad=new Adder();
        Adder ad1=new Adder();

        ad1.show();

        Integer s1= ad.add1(3,4);
        Float s2= ad.add2(4F, 4F);
        Character s3=ad.ans('c','a');

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        Adder name = new Adder();

        // Displaying O/P
        System.out.println("Geek name is: " + name.geek);

//        Integer c=add(2,3);
//        float ans=adding(3,4);
//        boolean ans1=ans(4,5);
//        System.out.println(c);
//        System.out.println(ans1);
//        System.out.println(ans);
//
//        String st = "Tutorial";
//        char chartoadd = 's';
//        st = st + chartoadd;
//        // performing concatenation
//        System.out.println(st);

    }
}
