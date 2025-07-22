import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;
        for (int i = 0; i * 5 <= n; i++) {
            if (((n - i * 5) % 3) == 0) {
                min = Math.min(min, i + ((n - i * 5) / 3));
            }
        }
        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else {
            System.out.println(min);
        }
    }
}