import java.util.Scanner;

public class Keyinput {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter the integer");
        int x= sc.nextInt();
        System.out.println("output is"+x);

        System.out.println("enter the string");
       String str=sc.next();
        System.out.println("output string is"+str);
    }
}
