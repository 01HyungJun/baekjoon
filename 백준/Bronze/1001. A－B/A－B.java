import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String array[] = s.split(" ");
        int a = Integer.parseInt(array[0]);
        int b = Integer.parseInt(array[1]);

        bw.write((a-b) + "\n");
        bw.flush();
        bw.close();
    }
}