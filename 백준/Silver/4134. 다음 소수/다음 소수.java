import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (long i = 0; i < n; i++) {
            long num = Long.parseLong(br.readLine());
            if (num <= 1) num = 2;
            while (true) {
                boolean flag = true;
                for (long m = (long) Math.sqrt(num); m >= 2; m--) {
                    if (num % m == 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) break;
                num++;
            }
            sb.append(num).append("\n");
        }

        System.out.println(sb);
    }
}