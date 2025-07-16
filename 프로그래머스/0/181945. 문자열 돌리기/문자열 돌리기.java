import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        char [] ch = new char[a.length()];
        a.getChars(0, a.length(), ch, 0);
        for(int i = 0; i < ch.length; i++){
            System.out.println(ch[i]);
        }
    }
}