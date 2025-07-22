import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = "";
        
        for (int i = 0; i <= n; i++) {
            int sum = i;
            s = String.valueOf(i);
            for (char ch : s.toCharArray()) {
                sum += (ch - '0');
            }
            if (sum == n) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}