import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[m];
        arr[0] = 1;
        long sum = 0;
        long ans = 0;
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
            sum += Long.parseLong(st.nextToken());
            
            ans += arr[(int) (sum % m)];
            arr[(int) (sum % m)]++;
        }
        System.out.println(ans);
    }
}