import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> list = new HashSet<>();

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            String chat = br.readLine();
            if (chat.equals("ENTER")) {
                list = new HashSet<>();
            }
            else if (!list.contains(chat)) {
                list.add(chat);
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}