public class Student {

    private String name;
    private int rollNumber;

    // Constructor to initialize name and rollNumber
    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    // Getter method for rollNumber
    public int getRollNumber() {
        return rollNumber;
    }

    // Method to print batch and student name using if-else
    public void printBatchUsingIfElse() {
        if (rollNumber >= 1 && rollNumber <= 2) {
            System.out.println("Batch 1: " + name);
        } else if (rollNumber >= 3 && rollNumber <= 4) {
            System.out.println("Batch 2: " + name);
        } else if (rollNumber >= 5 && rollNumber <= 6) {
            System.out.println("Batch 3: " + name);
        } else {
            System.out.println("Invalid roll number for batch assignment: " + name);
        }
    }

    // Method to print batch and student name using switch-case
    public void printBatchUsingSwitchCase() {
        switch (rollNumber) {
            case 1:
            case 2:
                System.out.println("Batch 1: " + name);
                break;
            case 3:
            case 4:
                System.out.println("Batch 2: " + name);
                break;
            case 5:
            case 6:
                System.out.println("Batch 3: " + name);
                break;
            default:
                System.out.println("Invalid roll number for batch assignment: " + name);
        }
    }

    public static void main(String[] args) {
        // Create a Student object with roll number 3
        Student student = new Student("John Doe", 3);

        // Use if-else to print batch and student name
        System.out.println("Using if-else:");
        student.printBatchUsingIfElse();

        // Use switch-case to print batch and student name
        System.out.println("\nUsing switch-case:");
        student.printBatchUsingSwitchCase();
    }
}



//public class Student {
//
//    String name;
//    Integer rollno;
//
//
//
//    Student (String name,Integer rollno)
//    {
//        this.name=name;
//        this.rollno=rollno;
//    }
//
//    public String info()
//    {
//        String ans=name+rollno;
//        return ans;
//
//    }
//
//    public static void main(String[] args)
//    {
//
//        Student s1=new Student("tejas",123);
//        Student s2=new Student("harsh",33);
////        Student s3=new Student();
//        System.out.println(s1.info());
//        System.out.println(s2.info());
////        System.out.println(s3.info());
//
//    }
//}
