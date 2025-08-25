import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj2636 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        new Boj2636().solution();
    }

    int H, W;
    int[][] arr;
    boolean[][] visited;
    int[] di = {1, 0, 0, -1};
    int[] dj = {0, -1, 1, 0};

    void solution() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        arr = new int[H][W];
        int cheese = 0;
        for(int i = 0; i < H; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < W; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1){
                    cheese += 1;
                }
            }
        }

        int ans = 0;
        int last = 0;
        while(true){
            visited = new boolean[H][W];
            int melt = dfs(0, 0);
            if(melt == 0) break;

            last = cheese;
            cheese -= melt;
            ans++;
        }

        wr.write(ans + "\n");
        wr.write(last + "\n");
        wr.flush();
        br.close();
        wr.close();
    }

    int dfs(int ci, int cj){
        visited[ci][cj] = true;
        int cnt = 0;

        for(int d = 0; d < 4; d++){
            int ni = ci + di[d];
            int nj = cj + dj[d];
            if(ni < 0 || ni >= H || nj < 0 || nj >= W || visited[ni][nj]) continue;

            if(arr[ni][nj] == 1){ // 치즈인 경우
                visited[ni][nj] = true;
                arr[ni][nj] = 0; // 치즈 녹임
                cnt++; // 녹인 개수 추가
            }else{ // 공기인 경우에는 계속 dfs 탐색
                cnt += dfs(ni, nj);
            }
        }

        return cnt;
    }
}
