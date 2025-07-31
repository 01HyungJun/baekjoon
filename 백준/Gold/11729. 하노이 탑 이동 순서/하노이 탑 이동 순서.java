import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

public class Main {
    static List<List<Integer>> list = new ArrayList<>();
    static int cnt = 0;

    public static void hanoi(int step, int start, int goal) {

        if (step == 0) return;

        hanoi(step - 1, start, 6 - start - goal);

        List<Integer> temp = new ArrayList<>(List.of(start, goal));
        list.add(temp);
        cnt++;

        hanoi(step - 1, 6 - start - goal, goal);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        hanoi(n, 1, 3);

        StringBuilder sb = new StringBuilder();
        sb.append(cnt).append("\n");
        for (List<Integer> t : list) {
            for (int i : t) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}