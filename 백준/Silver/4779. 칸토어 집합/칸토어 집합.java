import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void cantor(char[] seq, int n, int l, int r) {
        if (n == 0) {
            seq[l] = '-';
            return;
        }

        int t = (int) Math.pow(3, n - 1);

        for (int i = l + (t * 1); i < l + (t * 2); i++) {
            seq[i] = ' ';
        }

        cantor(seq, n - 1, l, l + (t * 1 - 1));
        cantor(seq, n - 1, l + (t * 2), r);
        return;
        
    }

    public static void cantor_rm(char[] seq, int l, int r) {

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            int n = Integer.parseInt(line);

            char[] seq = new char[(int) Math.pow(3, n)];
            cantor(seq, n, 0, (int) Math.pow(3, n));

            sb.append(String.valueOf(seq)).append("\n");
        }

        System.out.println(sb);
        
        
    }
}