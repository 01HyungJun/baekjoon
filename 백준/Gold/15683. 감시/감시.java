import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int min = Integer.MAX_VALUE;
    static int cam_num = 0;
    static int[][] room;

    public static void cam5(int y, int x) {
        for (int i = y; i >= 0; i--) {
            if (room[i][x] == 6) break;
            if (room[i][x] == 0) {
                room[i][x] = -1;
            }
        }
        for (int i = y; i < n; i++) {
            if (room[i][x] == 6) break;
            if (room[i][x] == 0) {
                room[i][x] = -1;
            }
        }
        for (int i = x; i >= 0; i--) {
            if (room[y][i] == 6) break;
            if (room[y][i] == 0) {
                room[y][i] = -1;
            }
        }
        for (int i = x; i < m; i++) {
            if (room[y][i] == 6) break;
            if (room[y][i] == 0) {
                room[y][i] = -1;
            }
        }
    }

    public static void cam(int y, int x, int[] arr) {
        for (int num : arr) {
            if (num == 0) {
                for (int i = y; i >= 0; i--) {
                    if (room[i][x] == 6) break;
                    if (room[i][x] <= 0) {
                        room[i][x]--;
                    }
                }
            }
            else if (num == 1) {
                for (int i = x; i < m; i++) {
                    if (room[y][i] == 6) break;
                    if (room[y][i] <= 0) {
                        room[y][i]--;
                    }
                }
            }
            else if (num == 2) {
                for (int i = y; i < n; i++) {
                    if (room[i][x] == 6) break;
                    if (room[i][x] <= 0) {
                        room[i][x]--;
                    }
                }
            }
            else if (num == 3) {
                for (int i = x; i >= 0; i--) {
                    if (room[y][i] == 6) break;
                    if (room[y][i] <= 0) {
                        room[y][i]--;
                    }
                }
            }
        }
    }

    public static void cam_inc(int y, int x, int[] arr) {
        for (int num : arr) {
            if (num == 0) {
                for (int i = y; i >= 0; i--) {
                    if (room[i][x] == 6) break;
                    if (room[i][x] < 0) {
                        room[i][x]++;
                    }
                }
            }
            else if (num == 1) {
                for (int i = x; i < m; i++) {
                    if (room[y][i] == 6) break;
                    if (room[y][i] < 0) {
                        room[y][i]++;
                    }
                }
            }
            else if (num == 2) {
                for (int i = y; i < n; i++) {
                    if (room[i][x] == 6) break;
                    if (room[i][x] < 0) {
                        room[i][x]++;
                    }
                }
            }
            else if (num == 3) {
                for (int i = x; i >= 0; i--) {
                    if (room[y][i] == 6) break;
                    if (room[y][i] < 0) {
                        room[y][i]++;
                    }
                }
            }
        }
    }

    public static int count() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (room[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }

    public static void dfs(int y, int x, int depth) {
        if (depth == 0) {
            min = Math.min(min, count());
            return;
        }

        if (x == m) {
            y++;
            x = 0;
        }

        int i = y;
        int j = x;
        while (i < n) {
            while (j < m) {
                if (room[i][j] == 1 || room[i][j] == 2 || room[i][j] == 3 || room[i][j] == 4) {
                    switch (room[i][j]) {
                        case 1:
                            for (int k = 0; k <= 3; k++) {
                                cam(i, j, new int[]{k});
                                dfs(i, j + 1, depth - 1);
                                cam_inc(i, j, new int[]{k});
                            }
                            break;

                        case 2:
                            for (int k = 0; k <= 1; k++) {
                                cam(i, j, new int[]{k, k + 2});
                                dfs(i, j + 1, depth - 1);
                                cam_inc(i, j, new int[]{k, k + 2});
                            }
                            break;

                        case 3:
                            for (int k = 0; k <= 3; k++) {
                                cam(i, j, new int[]{k, (k + 1) % 4});
                                dfs(i, j + 1, depth - 1);
                                cam_inc(i, j, new int[]{k, (k + 1) % 4});
                            }
                            break;

                        case 4:
                            for (int k = 0; k <= 3; k++) {
                                cam(i, j, new int[]{k, (k + 1) % 4, (k + 3) % 4});
                                dfs(i, j + 1, depth - 1);
                                cam_inc(i, j, new int[]{k, (k + 1) % 4, (k + 3) % 4});
                            }
                            break;

                        default:
                            break;
                    }
                    return;
                }
                j++;
            }
            i++;
            j = 0;
        }
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
                room[i][j++] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (room[i][j] == 5) {
                    cam5(i, j);
                }
                else if (room[i][j] == 1 || room[i][j] == 2 || room[i][j] == 3 || room[i][j] == 4) {
                    cam_num++;
                }
            }
        }

        dfs(0, 0, cam_num);

        System.out.println(min);
    }
}