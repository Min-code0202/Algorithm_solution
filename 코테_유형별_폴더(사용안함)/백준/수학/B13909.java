import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B13909 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public B13909() throws IOException {
        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int i = 1; i * i <= N; i++)
            cnt++;

        wr.write(Integer.toString(cnt));
        wr.flush();
        br.close();
        wr.close();
    }

    public static void main(String[] args) throws IOException {
        new B13909();
    }
}
