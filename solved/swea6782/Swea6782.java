import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Swea6782 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        new Swea6782().solution();
    }

    void solution() throws IOException{
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            long N = Long.parseLong(br.readLine()); 
            long ans = 0;

            while(N > 2) {
                long root = (long)Math.sqrt(N);
                if(root * root == N) { // 완전제곱수면 루트로 이동
                    N = root;
                    ans++;
                } else { // 다음 제곱수까지 +1
                    long nextSquare = (root + 1) * (root + 1);
                    ans += (nextSquare - N); 
                    N = nextSquare;
                }
            }

            wr.write("#" + tc + " " + ans + "\n");
        }

        wr.flush();
        br.close();
        wr.close();
    }
}
