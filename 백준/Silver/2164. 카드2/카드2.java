import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            queue.addLast(i);
        }

        boolean flag = true;
        while (queue.size() != 1) {
            if (flag) {
                queue.removeFirst();
            }
            else {
                queue.addLast(queue.removeFirst());
            }
            flag = !flag;
        }

        System.out.println(queue.peek());
    }
}