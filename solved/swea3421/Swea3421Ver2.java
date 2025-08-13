import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Swea3421Ver2 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        new Swea3421Ver2().solution();
    }

    boolean[][] disable;
    int cnt;
    int N, M;

    void solution() throws IOException{
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            disable = new boolean[N + 1][N + 1];

            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                disable[a][b] = true;
                disable[b][a] = true;
            }

            cnt = 0;
            solve(1, new ArrayList<>());

            wr.write("#" + tc + " " + cnt + "\n");
        }

        wr.flush();
        br.close();
        wr.close();
    }

    void solve(int depth, List<Integer> choose){
        if(depth > N){
            cnt++;
            return;
        }

        boolean enable = true;
        for(int c : choose){
            if(disable[depth][c]){
                enable = false;
                break;
            }
        }
        if(enable){
            choose.add(depth);
            solve(depth + 1, choose);
            choose.remove(choose.size() - 1);
        }
        solve(depth + 1, choose);
    }
}
