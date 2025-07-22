import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {

    static char[][] WB = {{ 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, 
                        { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
                        { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, 
                        { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
                        { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, 
                        { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
                        { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, 
                        { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }};
    static char[][] BW = {{ 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
                        { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, 
                        { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
                        { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, 
                        { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
                        { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
                        { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, 
                        { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int min = Integer.MAX_VALUE;
        char[][] board = new char[n][m];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                int countWB = 0;
                int countBW = 0;
                for (int k = 0; k < 8; k++) {
                    for (int a = 0; a < 8; a++) {
                        if (board[i + k][j + a] != WB[k][a]) {
                            countWB++;
                        }
                        if (board[i + k][j + a] != BW[k][a]) {
                            countBW++;
                        }
                    }
                }
                min = Math.min(min, Math.min(countWB, countBW));
            }
        }
        System.out.println(min);
    }
}