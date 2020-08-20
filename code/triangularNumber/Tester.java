import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        System.out.print("Enter a desired term: ");
        Scanner in = new Scanner(System.in);
        int n =0;
        try{
            n = in.nextInt();
            System.out.println("The term in position "+n+" is :"+ TriangularNumber.getTerm(n));
        }
        catch(NumberFormatException e){
            System.out.println("Only integer number is accepted");
        }
    }

}
