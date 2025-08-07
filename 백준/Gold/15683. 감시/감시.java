import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    static int n, m, min = Integer.MAX_VALUE;
    static int[][] room;
    static int[] dy = {-1, 0, 1, 0}, dx = {0, 1, 0, -1};
    static List<int[]> cctv = new ArrayList<>();
    static int[][][] camType = {
        {},
        { { 0 }, { 1 }, { 2 }, { 3 } },
        { { 0, 2 }, { 1, 3 } },
        { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 } },
        { { 0, 1, 2 }, { 1, 2, 3 }, { 2, 3, 0 }, { 3, 0, 1 } }
    };

    public static void camSite(int y, int x, int[] direct, int val) {
        for (int d : direct) {
            int i = y;
            int j = x;
            while (i >= 0 && i < n && j >= 0 && j < m) {
                if (room[i][j] == 6) {
                    break;
                }
                else if (room[i][j] <= 0) {
                    room[i][j] += val;
                }

                i += dy[d];
                j += dx[d];
            }
        }
    }

    public static void dfs(int cctvCnt) {
        if (cctvCnt == cctv.size()) {
            min = Math.min(min, count());
            return;
        }
        
        int[] temp = cctv.get(cctvCnt);
        for (int[] dir : camType[room[temp[0]][temp[1]]]) {
            camSite(temp[0], temp[1], dir, -1);
            dfs(cctvCnt + 1);
            camSite(temp[0], temp[1], dir, 1);
        }
    }

    public static int count() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (room[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        room = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int j = 0;

            while (st.hasMoreTokens()) {
                room[i][j] = Integer.parseInt(st.nextToken());
                if (room[i][j] == 1 || room[i][j] == 2 || room[i][j] == 3 || room[i][j] == 4) {
                    cctv.add(new int[]{i, j});
                }
                j++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (room[i][j] == 5) {
                    camSite(i, j, new int[]{0, 1, 2, 3}, -1);
                }
            }
        }

        dfs(0);
        System.out.println(min);
    }
}