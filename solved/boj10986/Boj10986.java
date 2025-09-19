import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj10986 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        new Boj10986().solution();
    }

    int N, M;
    int[] A;

    void solution() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long[] rest = new long[M];
        rest[0] = 1;
        long sum = 0;
        for(int i = 0; i < N; i++){
            sum += Integer.parseInt(st.nextToken());
            int mod = (int)((sum % M + M) % M);
            rest[mod]++;
        }

        long cnt = 0;
        for(int i = 0; i < M; i++){
            cnt += (rest[i] * (rest[i] - 1)) / 2;
        }

        wr.write(cnt + "\n");
        wr.flush();
        br.close();
        wr.close();
    }
}
