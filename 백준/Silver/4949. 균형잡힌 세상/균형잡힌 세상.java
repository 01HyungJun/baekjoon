import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Character> bracket;
        StringBuilder sb = new StringBuilder();

        String s = "";
        while (!(s = br.readLine()).equals(".")) {
            bracket = new ArrayDeque<>();
            boolean flag = true;
            for (char ch : s.toCharArray()) {
                if (ch == '(' || ch == '[') {
                    bracket.addFirst(ch);
                }
                else if (ch == ')') {
                    if (!bracket.isEmpty() && bracket.peekFirst() == '(') {
                        bracket.removeFirst();
                    }
                    else {
                        flag = false;
                        break;
                    }
                }
                else if (ch == ']') {
                    if (!bracket.isEmpty() && bracket.peekFirst() == '[') {
                        bracket.removeFirst();
                    }
                    else {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag && bracket.isEmpty()) sb.append("yes").append("\n");
            else sb.append("no").append("\n");
        }

        System.out.println(sb);
    }
}