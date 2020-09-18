import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MaxSalary {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        try{
            for(int i =0; i<n; i++){
                a[i] = in.nextInt();
            }
            System.out.println(getMaxSalary(a, n));
        }
        catch(NumberFormatException ex){
            ex.printStackTrace();
        }

        in.close();
    }

    private static String getMaxSalary(int[]a, int n) {
        StringBuilder maxSalary = new StringBuilder();
        String[] convertedA = new String[n];
        for(int i =0; i<n; i++){
            convertedA[i]= Integer.toString(a[i]);
        }
        Arrays.sort(convertedA, new Comparator<String>() {
            public int compare(String s1, String s2){
                if(s1.length()==s2.length()){
                    return s1.compareTo(s2);
                }
                String s3 = s1+s2;
                String s4 = s2+s1;
                return s3.compareTo(s4);
            }
        });
        for(int i =n-1; i>=0; i--){
            maxSalary.append(convertedA[i]);
        }
        return maxSalary.toString();
    }

}
