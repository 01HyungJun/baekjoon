import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char[][] board = new char[n][m];
        int[][] repaintB = new int[n + 1][m + 1];
        int[][] repaintW = new int[n + 1][m + 1];
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                int b = 0;
                int w = 0;
                if (flag) {
                    if (board[i][j] == 'B') {
                        w = 1;
                    }
                    else if (board[i][j] == 'W') {
                        b = 1;
                    }
                }
                else {
                    if (board[i][j] == 'B') {
                        b = 1;
                    }
                    else if (board[i][j] == 'W') {
                        w = 1;
                    }
                }
                repaintW[i + 1][j + 1] = repaintW[i][j + 1] + repaintW[i + 1][j] - repaintW[i][j] + w;
                repaintB[i + 1][j + 1] = repaintB[i][j + 1] + repaintB[i + 1][j] - repaintB[i][j] + b;
                flag = !flag;
            }
            if (m % 2 == 0) {
                flag = !flag;
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = k; i <= n; i++) {
            for (int j = k; j <= m; j++) {
                int x1 = i - k + 1, y1 = j - k + 1;
                int B = repaintB[i][j] - repaintB[x1 - 1][j] - repaintB[i][y1 - 1] + repaintB[x1 - 1][y1 - 1];
                int W = repaintW[i][j] - repaintW[x1 - 1][j] - repaintW[i][y1 - 1] + repaintW[x1 - 1][y1 - 1];
                ans = Math.min(ans, Math.min(B, W));
            }
        }
        System.out.println(ans);
    }
}