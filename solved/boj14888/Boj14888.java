import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj14888 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        new Boj14888().solution();
    }

    int N, A[], op[];
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    void solution() throws IOException{
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[N];
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        op = new int[4];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            op[i] = Integer.parseInt(st.nextToken());
        }

        solve(1, A[0]);
        

        wr.write(max + "\n"+ min);

        wr.flush();
        br.close();
        wr.close();
    }

    void solve(int depth, int res){
        if(depth == N){
            max = Math.max(max, res);
            min = Math.min(min, res);
            return;
        }

        for(int i = 0; i < 4; i++){
            if(op[i] > 0){
                op[i]--;
                if(i == 0){
                    solve(depth + 1, res + A[depth]);
                }else if(i == 1){
                    solve(depth + 1, res - A[depth]);
                }else if(i == 2){
                    solve(depth + 1, res * A[depth]);
                }else if(i == 3){
                    solve(depth + 1, res / A[depth]);
                }
                op[i]++;
            }
        }
    }
}
