import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        char [] ch = new char[a.length()];
        
        for(int n = 0; n < ch.length; n++) {
            if(65 <= a.charAt(n) && a.charAt(n) <= 90) {
                ch[n] = (char)(a.charAt(n) + 32);
            }
            else {
                ch[n] = (char)(a.charAt(n) - 32);
            }
        }

        System.out.println(ch);
    }
}