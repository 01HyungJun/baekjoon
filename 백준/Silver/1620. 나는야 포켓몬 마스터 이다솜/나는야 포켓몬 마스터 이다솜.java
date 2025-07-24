import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        String[] mapArr = new String[n + 1];
        Map<String, Integer> book = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String temp = br.readLine();
            book.put(temp, i);
            mapArr[i] = temp;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= m; i++) {
            String quiz = br.readLine();
            char ch = quiz.charAt(0);

            if ('1' <= ch && ch <= '9') {
                sb.append(mapArr[Integer.parseInt(quiz)]).append("\n");
            }
            else {
                sb.append(book.get(quiz)).append("\n");
            }
        }

        System.out.println(sb);
    }
}