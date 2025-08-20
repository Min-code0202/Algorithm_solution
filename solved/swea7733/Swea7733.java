import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Swea7733 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        new Swea7733().solution();
    }

    int N;
    boolean[][] visited;
    int[][] arr;

    void solution() throws IOException{
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            StringTokenizer st;
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int max = 1;
            for(int i = 1; i < 100; i++){
                int area = 0;
                for(int j = 0; j < N; j++){
                    for(int k = 0; k < N; k++){
                        if(arr[j][k] == i){
                            arr[j][k] = 0;
                        }
                    }
                }

                visited = new boolean[N][N];
                for(int j = 0; j < N; j++){
                    for(int k = 0; k < N; k++){
                        if(arr[j][k] != 0 && !visited[j][k]){
                            area += 1;
                            bfs(j, k, i);
                        }
                    }
                }

                max = Math.max(max, area);
            }

            wr.write("#" + tc + " " + max + "\n");
        }
        wr.flush();
        br.close();
        wr.close();
    }

    int[] di = {1, 0, -1, 0};
    int[] dj = {0, 1, 0, -1};

    void bfs(int si, int sj, int eat){
        Queue<int[]> q = new ArrayDeque<>();
        visited[si][sj] = true;
        q.offer(new int[]{si, sj});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int ci=  cur[0];
            int cj = cur[1];

            for(int d = 0; d < 4; d++){
                int ni = ci + di[d];
                int nj = cj + dj[d];
                if(0 <= ni && ni < N && 0 <= nj && nj < N && arr[ni][nj] != 0 && !visited[ni][nj]){
                    visited[ni][nj] = true;
                    q.offer(new int[]{ni, nj});
                }
            }
        }
    }
}
