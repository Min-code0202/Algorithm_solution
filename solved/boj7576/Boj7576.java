import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj7576 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        new Boj7576().solution();
    }
    
    void solution() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        Queue<int[]> q = new ArrayDeque<>();
        int[][] visited = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1){
                    q.offer(new int[]{i, j});
                    visited[i][j] = 1;
                }
            }
        }

        int[] di = {1, 0, 0, -1};
        int[] dj = {0, 1, -1, 0};

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int ci = cur[0];
            int cj = cur[1];
            for(int d = 0; d < 4; d++){
                int ni = ci + di[d];
                int nj = cj + dj[d];
                if(0 <= ni && ni < N && 0 <= nj && nj < M && visited[ni][nj] == 0 && arr[ni][nj] == 0){
                    visited[ni][nj] = visited[ci][cj] + 1;
                    arr[ni][nj] = 1;
                    q.offer(new int[]{ni, nj});
                }
            }
        }

        int ans = -1;
        boolean flag = false;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                ans = Math.max(ans, visited[i][j]);
                if(arr[i][j] == 0){
                    ans = -1;
                    flag = true;
                    break;
                }
            }
            if(flag){
                break;
            }
        }

        if(ans == -1) wr.write("-1");
        else wr.write((ans - 1) + "\n");
        wr.flush();
        br.close();
        wr.close();
    }
}
