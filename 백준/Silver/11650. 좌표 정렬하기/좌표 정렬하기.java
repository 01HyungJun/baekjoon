import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            String[] tokens = s.split(" ");

            arr[i][0] = Integer.parseInt(tokens[0]);
            arr[i][1] = Integer.parseInt(tokens[1]);
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            else return Integer.compare(a[1], b[1]);
        });

        StringBuilder sb = new StringBuilder();
        for (int[] temp : arr) {
            sb.append(temp[0]).append(" ").append(temp[1]).append("\n");
        }
        System.out.println(sb);
    }
}