import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();
        int turn = 1;
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            if (num == turn) {
                turn++;
                while (!stack.isEmpty() && stack.peek() == turn) {
                    stack.pop();
                    turn++;
                }
            }
            else if (!stack.isEmpty() && num > stack.peek()) {
                System.out.println("Sad");
                return;
            }
            else {
                stack.push(num);
            }
        }
        System.out.println("Nice");
    }
}