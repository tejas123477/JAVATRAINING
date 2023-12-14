import java.util.Date;

public class HelloWorld {
    //package com.cts.meera;
    /**
     * This Class greets everyone
     *
     * @author Gyanendra
     * @since 01-12-2020
     */
//
//    public class HelloWorld{
//        public static void main(String[] args){
//
//            int [] numArray = {3, 3, 5, 6, 8, 9, 10};
//            int sum = 0;
//            for(int i = 0; i<numArray.length; i++){
//                sum += numArray[i];
//            }
//            float avg = sum / numArray.length;
//            System.out.println("The avg numbers is "+ avg);
//        }

    /*
     *This block of code is for intialising
     *Greeting
     *
     */
    static String greeting = "Hello World";

    static Date today;
// int x = 10;
// char myfav = 'a';


    /**
     * Prints the main
     * takes arguments from cmd line as strings
     *
     * @param args take arg from cmd line
     */
    public static void main(String[] args) {

        double randomValue = Math.random();
        System.out.println("Random value: " + randomValue);
//            System.out.println(greeting + "From Gyanendra" + "04/12" );
//            Integer a=10;
//            Integer b=20;
//            System.out.println(a+b);
//            today=new Date();
//            System.out.println(today);
//            int [] numArray = {3, 3, 5, 6, 8, 9, 10};
//            int sum = 0;
//            for(int i = 0; i<numArray.length; i++){
//                sum += numArray[i];
//            }
//            float avg = sum / numArray.length;
//            System.out.println("The avg numbers is "+ avg);

//             int[][] matrix = {
//                    { 1, 2, 3 },
//                    { 4, 5, 6 },
//                    { 7, 8, 9 }
//            };
//            int sum=0;
//            for (int i = 0; i < matrix.length; i++) { //this equals to the row in our matrix.
//                for (int j = 0; j < matrix[i].length; j++) {
//                    sum=sum+matrix[i][j];//this equals to the column in each row.
////                    System.out.print(matrix[i][j] + " ");
//
//                }
//                System.out.println(); //change line on console as row comes to end in the matrix.
//            }
//            System.out.println("sum is"+sum);
//        }
        int[][] matrix = {
                {1, 2, 3,7,6},
                {4, 5, 6},
                {7, 8, 9,8},
                {5}
        };

        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[i].length;j++)
            {
                System.out.println(matrix[i][j]+" ");
            }
        }
        System.out.println("length of each row");

        System.out.println(matrix[0].length);
        System.out.println(matrix[1].length);
        System.out.println(matrix[2].length);
        System.out.println(matrix[3].length);
//    }
    }
}

