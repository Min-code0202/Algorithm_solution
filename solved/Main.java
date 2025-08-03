import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    

    public void solution() throws IOException {
        

        wr.flush();
        wr.close();
        br.close();
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
