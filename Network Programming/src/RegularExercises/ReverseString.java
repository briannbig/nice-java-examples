package RegularExercises;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println("Enter s String to be reversed: ");
        Scanner sc = new Scanner(System.in);
        System.out.println("Reversed String: " + reverse(sc.next()));
    }
    public static  String reverse(String string){
        StringBuffer buffer = null;
        String result = "";
        for (int i = string.length(); i > 0; i--){
            buffer.append(string.charAt(i));
        }
        return buffer.toString();
    }
}
