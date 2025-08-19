import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Boj2839 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        new Boj2839().solution();
    }

    void solution() throws IOException{
        int N = Integer.parseInt(br.readLine());
        
        int five = N / 5;
        while (five >= 0) {
            int remain = N - five * 5;
            if (remain % 3 == 0) {
                wr.write((five + remain / 3) + "\n");
                return;
            }
            five--;
        }
        wr.write(-1 + "\n");

        wr.flush();
        br.close();
        wr.close();
    }
}
