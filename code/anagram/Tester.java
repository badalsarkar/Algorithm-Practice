
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        System.out.print("Enter a word: ");
        Scanner in = new Scanner(System.in);
        String word = in.nextLine(); 
        int c = Anagram.doAnagram("",word);
        System.out.println("Total number of Anagram :"+c);
    }
}
