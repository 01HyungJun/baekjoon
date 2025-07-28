import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        for (int i = m; i <= n; i++) {
            boolean flag = false;
            for (int j = 2; j <= (int) Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = true;
                    break;
                }
            }
            if (flag || i == 1) continue;
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}