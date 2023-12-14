public class StringBManip {

    public static void main(String[] args) {


        StringBuilder str = new StringBuilder("a brown fox jumped");
        str.setCharAt(0,Character.toUpperCase(str.charAt(0)));
        for(int i = 0 ; i<str.length() ; i++) {
            if(str.charAt(i) == ' ') {
                str.setCharAt(i+1, Character.toUpperCase(str.charAt(i+1)));
            }
        }
        System.out.println(str);
        // TODO Auto-generated method stub
        // Create two StringBuilder objects
        StringBuilder sb1 = new StringBuilder("Employee");
        StringBuilder sb2 = new StringBuilder("Company");

        // Check if they are equal
        if (sb1.toString().equals(sb2.toString())) {
            System.out.println("The StringBuilder objects are equal.");
        } else {
            System.out.println("The StringBuilder objects are not equal.");
        }

        // Print their lengths
        System.out.println("Length of StringBuilder 1: " + sb1.length());
        System.out.println("Length of StringBuilder 2: " + sb2.length());

        // Print substring from index 4 till the end
        System.out.println("Substring from index 4 till the end: " + sb1.substring(4));

        // Concatenate both strings
        StringBuilder concatenated = new StringBuilder(sb1);
        concatenated.append(sb2);
        System.out.println("Concatenated StringBuilder: " + concatenated.toString());

        // Print them in lowercase and uppercase
        System.out.println("Lowercase: " + sb1.toString().toLowerCase());
        System.out.println("Uppercase: " + sb2.toString().toUpperCase());

        // Find the index of "lo" in StringBuilder 1
        int indexOfLo = sb1.indexOf("lo");
        System.out.println("Index of 'lo' in StringBuilder 1: " + indexOfLo);

        // Prefix "Big" to StringBuilder 2
        sb2.insert(0, "Big");
        System.out.println("After prefixing 'Big' to StringBuilder 2: " + sb2.toString());
    }

}