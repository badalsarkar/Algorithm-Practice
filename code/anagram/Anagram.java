
public class Anagram {
    public static int doAnagram(String tempWord, String word) {
        int c=0;
       if(word.length()==1){
           System.out.println(tempWord+word);
           c++;
           return c;
       }
       for(int i=0; i<word.length(); i++){
           String s1 = word.substring(i,i+1);
           String s2 = word.substring(0, i);
           String s3=word.substring(i+1);
           c=c+doAnagram(tempWord+s1, s2+s3);
        }
       return c;
    }
}
