package ObjectClassMethods;

//String equals() method in Java compares the content of two strings
//It compares the value's character by character,
// Not two strings are stored in the same memory location.
// The String equals() method overrides the equals() method of the object class.
//false if any of the characters are not matched.
//true if all characters are matched in the Strings.
public class EqualssMethod {
    public static void main(String[] args) {
        String str1="learn java";
        String str2="learn java";
        String str3="learn python";
        boolean result;

        // Comparing str1 with str2
        result = str1.equals(str2);
        System.out.println(result);//true

        // Comparing str1 with str3
        result = str1.equals(str3);
        System.out.println(result);//false

        // Comparing str3 with str1
        result = str3.equals(str1);
        System.out.println(result);//false

    }
}

//Syntax
//string.equals(object)
//
//Return Type: The return type for the equals method is Boolean.

///Case-Insensitive Comparison of Strings
//It compares the difference between uppercase and lowercase characters.
// We compare three strings using the equalsIgnoreCase()
//?-----------------------------------------------------------------
// Working equalsIgnoreCase() Method
/*
import java.io.*;

public class Geeks
{
    public static void main(String[] args)
    {
        // Define three strings
        String str1 = "Hello";
        String str2 = "hello";
        String str3 = "WORLD";


        // Comparison between str1 and str2
        System.out.println("str1.equals(str2): "+ str1.equals(str2));

        // Comparison between str1 and str2(Case Insensitive)
        System.out.println("str1.equalsIgnoreCase(str2): "+ str1.equalsIgnoreCase(str2));

        // Comparison between str2 and str3
        System.out.println("str2.equalsIgnoreCase(str3): "+ str2.equalsIgnoreCase(str3));
    }
}
*/
