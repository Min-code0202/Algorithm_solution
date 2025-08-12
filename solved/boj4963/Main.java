import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0){
                break;
            }
    
            int[][] arr = new int[h][w];
            
            for(int i = 0; i < h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt = 0;
            int[][] visited = new int[h][w];
            Queue<int[]> q = new ArrayDeque<>();
            int[][] dr = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
            for(int i = 0; i < h; i++){
                for(int j = 0; j < w; j++){
                    if(arr[i][j] == 1 && visited[i][j] == 0){
                        cnt += 1;
                        visited[i][j] = cnt;
                        q.offer(new int[]{i, j});

                        while(!q.isEmpty()){
                            int[] cur = q.poll();
                            for(int[] d : dr){
                                int ni = cur[0] + d[0];
                                int nj = cur[1] + d[1];
                                if(0 <= ni && ni < h && 0 <= nj && nj < w && arr[ni][nj] == 1 && visited[ni][nj] == 0){
                                    visited[ni][nj] = cnt;
                                    q.offer(new int[]{ni, nj});
                                }
                            }
                        }
                    }
                }
            }
            wr.write(cnt + "\n");
        }

        wr.flush();
        wr.close();
        br.close();
    }
}
