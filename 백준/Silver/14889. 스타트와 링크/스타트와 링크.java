import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    static int n, min = Integer.MAX_VALUE;
    static int[] team;
    // static int team_size = 0;
    static boolean[] players;
    static int[][] stat;
    static boolean zero_flag = false;

    static int cal_stat(int[] team_players) {
        int sum = 0;
        for (int i = 0; i < team_players.length; i++) {
            for (int j = i; j < team_players.length; j++) {
                sum += (stat[team_players[i]][team_players[j]] + stat[team_players[j]][team_players[i]]);
            }
        }
        return sum;
    }

    static void dfs(int depth, int start_idx) {
        if (depth == n / 2) {
            int[] team2 = new int[n / 2];
            int idx = 0;
            for (int i = 0; i < n; i++) {
                if (!players[i]) {
                    team2[idx++] = i;
                }
            }
            min = Math.min(min, Math.abs(cal_stat(team) - cal_stat(team2)));
            if (min == 0) {
                zero_flag = true;
            }
            return;
        }

        for (int i = start_idx; i < n; i++) {
            if (players[i]) { continue; }

            team[depth] = i;
            players[i] = true;
            // team_size++;

            // if (n - i < (n / 2 - team_size)) {
            //     return;
            // }
            if(!zero_flag) {
                dfs(depth + 1, i + 1);
            }
            if(zero_flag) {
                return;
            }

            team[depth] = 0;
            players[i] = false;
            // team_size--;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        team = new int[n / 2];
        players = new boolean[n];
        stat = new int[n][n];
        
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                stat[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(min);
    }
}