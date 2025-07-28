import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] isNotPrime = new boolean[123456 * 2 + 1];
        isNotPrime[0] = true; isNotPrime[1] = true;

        for (int i = 2; i < Math.sqrt(123456 * 2); i++) {
            for (int j = 2; j < isNotPrime.length; j++) {
                if (j / i != 1 && j % i == 0) {
                    isNotPrime[j] = true;
                }
            }
        }

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            int cnt = 0;
            for (int i = n + 1; i <= 2 * n; i++) {
                if (!isNotPrime[i]) cnt++;
            }

            System.out.println(cnt);
        }
    }
}