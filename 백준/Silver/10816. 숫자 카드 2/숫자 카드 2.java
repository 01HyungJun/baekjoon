import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> cards = new HashMap<>();
        while(st.hasMoreTokens()) {
            int temp = Integer.parseInt(st.nextToken());
            if(!cards.containsKey(temp)) {
                cards.put(temp, 0);
            }
            cards.put(temp, cards.get(temp) + 1);
        }

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            int temp = Integer.parseInt(st.nextToken());
            if (cards.containsKey(temp)) {
                sb.append(cards.get(temp)).append(" ");
            }
            else {
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb);
    }
}