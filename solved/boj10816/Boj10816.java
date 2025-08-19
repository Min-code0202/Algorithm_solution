import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj10816 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        new Boj10816().solution();
    }

    final int len = 10_000_001;

    void solution() throws IOException{
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cnt = new int[2 * len];

        for(int i = 0; i < N; i++){
            int n = Integer.parseInt(st.nextToken());
            cnt[n + len]++;
        }
        
        
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            int idx = Integer.parseInt(st.nextToken());
            wr.write(cnt[idx + len] + " ");
        }

        wr.flush();
        br.close();
        wr.close();
    }
}
