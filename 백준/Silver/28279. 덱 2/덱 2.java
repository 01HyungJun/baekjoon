import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());

            switch (cmd) {
                case 1:
                    int num = Integer.parseInt(st.nextToken());
                    deque.addFirst(num);
                    break;
                
                case 2:
                    int num2 = Integer.parseInt(st.nextToken());
                    deque.addLast(num2);
                    break;

                case 3:
                    if (!deque.isEmpty()) {
                        sb.append(deque.removeFirst()).append("\n");
                    }
                    else {
                        sb.append(-1).append("\n");
                    }
                    break;

                case 4:
                    if (!deque.isEmpty()) {
                        sb.append(deque.removeLast()).append("\n");
                    }
                    else {
                        sb.append(-1).append("\n");
                    }
                    break;

                case 5:
                    sb.append(deque.size()).append("\n");
                    break;

                case 6:
                    sb.append(deque.isEmpty() ? 1 : 0).append("\n");
                    break;

                case 7:
                    if (!deque.isEmpty()) {
                        sb.append(deque.peekFirst()).append("\n");
                    }
                    else {
                        sb.append(-1).append("\n");
                    }
                    break;

                case 8:
                    if (!deque.isEmpty()) {
                        sb.append(deque.peekLast()).append("\n");
                    }
                    else {
                        sb.append(-1).append("\n");
                    }
                    break;

                default:
                    break;
            }
        }
        System.out.println(sb);
    }
}