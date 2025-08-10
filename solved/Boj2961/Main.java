import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }

    int N;
    int[][] arr;
    boolean[] isSelected;
    int ans = Integer.MAX_VALUE;

    void solution() throws IOException{
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        isSelected = new boolean[N];
        solve(0);

        wr.write(ans + "\n");
        
        wr.flush();
        br.close();
        wr.close();
    }

    void solve(int depth){
        if(depth >= N){
            int S = 1;
            int B = 0;
            boolean flag = false;
            for(int i = 0; i < N; i++){
                if(isSelected[i]){
                    S *= arr[i][0];
                    B += arr[i][1];
                    flag = true;
                }
            }

            if(flag) ans = Math.min(ans, Math.abs(S - B));
            return;
        }

        isSelected[depth] = true;
        solve(depth + 1);
        isSelected[depth] = false;
        solve(depth + 1);
    }
}
