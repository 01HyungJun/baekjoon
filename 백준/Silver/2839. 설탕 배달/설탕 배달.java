import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;
        for (int i = 0; i * 5 <= n; i++) {
            for (int j = 0; j * 3 + i * 5 <= n; j++) {
                if ((i * 5 + j * 3) == n) {
                    min = Math.min(min, i + j);
                }
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