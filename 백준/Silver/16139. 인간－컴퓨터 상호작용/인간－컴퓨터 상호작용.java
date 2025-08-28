import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int q = Integer.parseInt(br.readLine());

        int[][] arr = new int[26][s.length() + 1];

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < 26; j++) {
                arr[j][i] = arr[j][i - 1];
            }
            arr[s.charAt(i - 1) - 'a'][i] += 1;
        }

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            char alpha = st.nextToken().charAt(0);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(arr[alpha - 'a'][end + 1] - arr[alpha - 'a'][start]).append("\n");
        }
        System.out.println(sb);
    }
}