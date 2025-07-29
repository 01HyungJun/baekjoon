import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static class balloon {
        int paper;
        int index;

        balloon(int paper, int index) {
            this.paper = paper;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Deque<balloon> deque = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int idx = 1;
        while (st.hasMoreTokens()) {
            balloon b = new balloon(Integer.parseInt(st.nextToken()), idx++);
            deque.addLast(b);
        }

        StringBuilder sb = new StringBuilder();

        int size = deque.size();
        while (!deque.isEmpty()) {
            balloon temp = deque.removeFirst();
            int num = temp.paper;
            sb.append(temp.index).append(" ");
            
            if (deque.isEmpty()) break;
            if (num > 0) {
                for (int i = 0; i < num - 1; i++) {
                    deque.addLast(deque.removeFirst());
                }
            }
            else if (num < 0) {
                for (int i = 0; i < -num; i++) {
                    deque.addFirst(deque.removeLast());
                }
            }
        }
        System.out.println(sb);
    }
}