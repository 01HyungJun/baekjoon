import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        System.out.println(factorial(n));
    }

    public static long factorial (long num1) {
        if (num1 == 1 || num1 == 0) return 1;
        return factorial(num1 - 1) * num1;
    }
}