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

public class Boj16234 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        new Boj16234().solution();
    }

    int N, L, R;
    int[][] arr;
    boolean[][] visited;

    void solution() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;

        while(true){
            int tried = 0;
            visited = new boolean[N][N];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(!visited[i][j]){
                        tried += bfs(i, j);
                    }
                }
            }
            if(tried == 0){
                break;
            }
            ans++;
        }

        wr.write(ans + "\n");

        wr.flush();
        br.close();
        wr.close();
    }

    int[][] dr = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    int bfs(int si, int sj){
        int sum = 0;
        int cnt = 0;
        Queue<int[]> q = new ArrayDeque<>();
        List<int[]> list = new ArrayList<>();

        q.offer(new int[]{si, sj});
        list.add(new int[]{si, sj});
        visited[si][sj] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int ci = cur[0];
            int cj = cur[1];
            sum += arr[ci][cj];
            cnt += 1;

            for(int[] d : dr){
                int ni = ci + d[0];
                int nj = cj + d[1];
                if(0 <= ni && ni < N && 0 <= nj && nj < N && !visited[ni][nj]){
                    int diff = Math.abs(arr[ci][cj] - arr[ni][nj]);
                    if(L <= diff && diff <= R){
                        q.offer(new int[]{ni, nj});
                        visited[ni][nj] = true;
                        list.add(new int[]{ni, nj});
                    }
                }
            }
        }
        
        if(list.size() == 1) return 0;
        
        for(int[] point : list){
            arr[point[0]][point[1]] = sum / cnt;
        }
        
        return 1;
    }
}
