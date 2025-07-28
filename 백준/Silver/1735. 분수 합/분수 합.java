import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a1 = Long.parseLong(st.nextToken());
        long a2 = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long b1 = Long.parseLong(st.nextToken());
        long b2 = Long.parseLong(st.nextToken());

        long base_lcm = LCM(a2, b2);
        a1 = a1 * (base_lcm / a2);
        b1 = b1 * (base_lcm / b2);
        long result_hat = a1 + b1;
        long gcd = GCD(result_hat, base_lcm);
        System.out.println(result_hat / gcd + " " + base_lcm / gcd + "\n");
    }

    public static long GCD(long a, long b) {
        if (a % b == 0) return b;
        return GCD(b, a % b);
    }

    public static long LCM(long a, long b) {
        return a * b * GCD(a, b);
    }
}