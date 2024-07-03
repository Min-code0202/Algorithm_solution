import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B4134 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public B4134() throws Exception {
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            long n = Long.parseLong(br.readLine());
            while (true) {
                long cnt = 0;
                for (long i = 2; i <= Math.sqrt(n); i++) {
                    if (n % i == 0) {
                        cnt++;
                        break;
                    }
                }
                if (cnt == 0) {
                    if (n == 0 || n == 1)
                        n = 2;
                    wr.write(n + "\n");
                    break;
                }
                n++;
            }
        }

        wr.flush();
        br.close();
        wr.close();
    }

    public static void main(String[] args) throws Exception {
        new B4134();
    }
}
