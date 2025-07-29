import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] ds = new boolean[n];
        int i = 0;
        while (st.hasMoreTokens()) {
            if (st.nextToken().equals("0")) {
                ds[i++] = true;
            }
            else {
                ds[i++] = false;
            }
        }

        st = new StringTokenizer(br.readLine());
        Deque<Integer> queuestack = new ArrayDeque<>();
        i = 0;
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            if (ds[i++]) {
                queuestack.addLast(num);
            }
        }

        int m = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            queuestack.addFirst(num);
            sb.append(queuestack.removeLast()).append(" ");
        }

        System.out.println(sb);
    }
}