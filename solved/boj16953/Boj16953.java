import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int ans = 1;
        while (B > A) {
            if (B % 2 == 0) { 
                B /= 2;
            } else if (B % 10 == 1) {
                B /= 10;
            } else {
                break;
            }
            ans++;
        }

        if (B == A) wr.write(ans + "\n");
        else wr.write("-1\n");

        wr.flush();
        wr.close();
        br.close();
    }
}
