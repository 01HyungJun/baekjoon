import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();
        int result1 = Integer.parseInt(a) + Integer.parseInt(b) - Integer.parseInt(c);
        System.out.println(result1);

        int result2 = Integer.parseInt(a + b) - Integer.parseInt(c);
        System.out.println(result2);
    }
}