import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1697 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        new Boj1697().solution();
    }

    void solution() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] visited = new int[200001];
        int[] dr = {-1, 1, 2};

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(N);
        visited[N] = 1;

        while(!q.isEmpty()){
            int c = q.poll();
            if(c == K){
                break;
            }
            for(int d = 0; d < 3; d++){
                int ni = c + dr[d];
                if(dr[d] == 2){
                    ni = c * dr[d];
                }
                if(0 <= ni && ni < 200001 && visited[ni] == 0){
                    visited[ni] = visited[c] + 1;
                    q.offer(ni);
                }
            }
        }

        wr.write((visited[K] - 1) + "\n");
        wr.flush();
        br.close();
        wr.close();
    }
}
