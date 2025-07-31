import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    static int n, m;
    static int[] arr, temp;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    

    static void dfs(int depth, int start) {
        if (depth == m) {
            temp = Arrays.copyOf(arr, arr.length);
            Arrays.sort(temp);
            for (int i : temp) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                dfs(depth + 1, i + 1);
                visited[i] = false;
            }
        }
        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        temp = new int[m];

        visited = new boolean[n + 1];

        dfs(0, 1);

        System.out.println(sb);
    }
}