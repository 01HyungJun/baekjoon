import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int n, cnt = 0;
    static int[][] visited = new int[15][15];

    static void dfs(int depth) {
        if (depth == n) {
            cnt++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[depth][i] == 0) {
                change_stat(depth, i, 1);
                dfs(depth + 1);
                change_stat(depth, i, -1);
            }
        }
    }

    static void change_stat(int y, int x, int tf) {
        int y1 = y;
        int x1 = x;

        for (int i = y1; i < n; i++) {
            visited[i][x1] += tf;
        }
        while (y1 + 1 < n && x1 - 1 >= 0) {
            visited[++y1][--x1] += tf;
        }

        y1 = y;
        x1 = x;
        while (y1 + 1 < n && x1 + 1< n) {
            visited[++y1][++x1] += tf;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        dfs(0);

        System.out.println(cnt);
    }
}