import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Set<String> names = new HashSet<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String exist = st.nextToken();

            if (exist.equals("leave")) {
                names.remove(name);
            }
            else {
                names.add(name);
            }
        }

        List<String> ans = new ArrayList<>(names);

        ans.sort(Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (String s : ans) {
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}