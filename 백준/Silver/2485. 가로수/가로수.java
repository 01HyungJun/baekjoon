import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] tree = new long[n];
        long[] gap = new long[n-1];
        tree[0] = Long.parseLong(br.readLine());
        for (int i = 1; i < n; i++) {
            tree[i] = Long.parseLong(br.readLine());
            gap[i - 1] = tree[i] - tree[i - 1];
        }
        long min_GCD = GCD(gap[0], gap[1]);
        for (int i = 1; i < n - 1; i++) {
            min_GCD = GCD(min_GCD, gap[i]);
            if (min_GCD == 1) break;
        }
        long cnt = ((tree[n - 1] - tree[0]) / min_GCD) - n + 1;
        System.out.println(cnt);
    }

    public static long GCD(long a, long b) {
        if (a % b == 0) {
            return b;
        }
        return GCD(b, a % b);
    }
}