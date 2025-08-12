import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    int N, M;
    List<Integer>[] graph;


    int solve(int start){
        boolean[] visited = new boolean[N + 1];
        visited[start] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        
        int cnt = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int nxt : graph[cur]){
                if(!visited[nxt]){
                    visited[nxt] = true;
                    q.offer(nxt);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    void solution() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for(int i = 0; i < N + 1; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            graph[b].add(a);
        }

        int[] rank = new int[N + 1];
        for(int i = 1; i <= N; i++){
            int cnt = solve(i);
            rank[i] = cnt;
        }

        int max = 0;
        for(int i = 1; i <= N; i++){
            if(max < rank[i]){
                max = rank[i];
            }
        }

        for(int i = 1; i <= N; i++){
            if(max == rank[i]){
                wr.write(i + " ");
            }
        }

        wr.flush();
        br.close();
        wr.close();
    }


    public static void main(String[] args) throws IOException{
        new Main().solution();
    }
}
