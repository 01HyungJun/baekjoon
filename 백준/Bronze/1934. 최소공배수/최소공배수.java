import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            List<Integer> a_factor = new ArrayList<>();
            int gcd = 1;
            for (int j = 1; j <= a / 2; j++) {
                if (a % j == 0) {
                    a_factor.add(a / j);
                }
            }
            for (int k = 1; k <= b / 2; k++) {
                if (b % k == 0 && a_factor.contains(b / k)) {
                    gcd = b / k;
                    break;
                }
            }

            sb.append(a * b / gcd).append("\n");
        }

        System.out.println(sb);
    }
}