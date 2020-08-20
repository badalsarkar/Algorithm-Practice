import java.util.Scanner;

public class Tester {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number: ");
        try{
            int number = in.nextInt();
            if(number<0){
                System.out.println("Only positive integer is accepted");
                System.exit(0);
            }
            else{
                System.out.println("The factorial of number "+number +" is "+ Factorial.getFactorial(number));
            }
        }
        catch(NumberFormatException e){
            System.out.println("Only integer value is accepted" );
        }
    }

}
