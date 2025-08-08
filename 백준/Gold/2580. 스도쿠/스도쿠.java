import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    static int[][] board = new int[9][9];
    static List<int[]> empty = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static boolean flag = false;

    static void dfs(int empty_num) {
        if (empty_num == empty.size()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(board[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            flag = true;
            return;
        }

        int[] temp = empty.get(empty_num);
        for (int i = 1; i <= 9; i++) {
            if (check_num(temp[0], temp[1], i)) {
                board[temp[0]][temp[1]] = i;
                if (!flag) {
                    dfs(empty_num + 1);
                }
                if (flag) {
                    return;
                }
                board[temp[0]][temp[1]] = 0;
            }
        }
    }

    static boolean check_num(int y, int x, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[i][x] == num || board[y][i] == num) {
                return false;
            }
        }

        int box_y = (y / 3) * 3;
        int box_x = (x / 3) * 3;

        for (int i = box_y; i < box_y + 3; i++) {
            for (int j = box_x; j < box_x + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 0) {
                    empty.add(new int[]{i, j});
                }
            }
        }

        dfs(0);
    }
}