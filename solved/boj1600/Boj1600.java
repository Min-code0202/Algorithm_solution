import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Boj1600 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        new Boj1600().solution();
    }

    int K, W, H;
    int[][] arr;

    void solution() throws IOException{
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr = new int[H][W];
        for(int i = 0; i < H; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < W; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = bfs(0, 0);
        wr.write(ans + "\n");
        wr.flush();
        br.close();
        wr.close();
    }

    int[] di = {1, 0, -1, 0};
    int[] dj = {0, -1, 0, 1};
    int[][] horse = {{-2, -1}, {-2, 1}, {-1, 2}, {1, 2},
                    {2, 1}, {2, -1}, {1, -2}, {-1, -2}};

    int bfs(int si, int sj){
        int[][][] visited = new int[K + 1][H][W];
        visited[0][si][sj] = 1;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{si, sj, 0});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int ci = cur[0];
            int cj = cur[1];
            int jump = cur[2];
            if(ci == H - 1 && cj == W - 1) return visited[jump][ci][cj] - 1;
            
            // 원숭이
            for(int d = 0; d < 4; d++){
                int ni = ci + di[d];
                int nj = cj + dj[d];
                if(isOutOfRange(ni, nj)) continue;
                if(visited[jump][ni][nj] != 0) continue;
                if(arr[ni][nj] == 1) continue;
                visited[jump][ni][nj] = visited[jump][ci][cj] + 1;
                q.offer(new int[]{ni, nj, jump});
            }
            // 말
            if(jump < K){
                for(int d = 0; d < 8; d++){
                    int ni = ci + horse[d][0];
                    int nj = cj + horse[d][1];
                    if(isOutOfRange(ni, nj)) continue;
                    if(visited[jump + 1][ni][nj] != 0) continue;
                    if(arr[ni][nj] == 1) continue;
                    visited[jump + 1][ni][nj] = visited[jump][ci][cj] + 1;
                    q.offer(new int[]{ni, nj, jump + 1});
                }
            }
        }
        
        return -1;
    }

    boolean isOutOfRange(int ni, int nj){
        if(0 <= ni && ni < H && 0 <= nj && nj < W) return false;
        return true;
    }
}
