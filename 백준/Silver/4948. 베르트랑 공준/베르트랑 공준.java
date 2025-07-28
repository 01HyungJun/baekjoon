import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] isPrime = new boolean[123456 * 2 + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false; isPrime[1] = false;

        for (int i = 2; i < Math.sqrt(123456 * 2); i++) {
            if (isPrime[i]) {
                for (int j = i * 2; j < isPrime.length; j += i) {
                    isPrime[j] = false;
                }
            }
            
        }

        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            int cnt = 0;
            for (int i = n + 1; i <= 2 * n; i++) {
                if (isPrime[i]) cnt++;
            }
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}