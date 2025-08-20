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

public class Swea1238 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        new Swea1238().solution();
    }

    List<Integer>[] graph;
    int N;
    final int size = 101;

    void solution() throws IOException{
        for(int tc = 1; tc <= 10; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            graph = new ArrayList[size];
            for(int i = 0; i < size; i++){
                graph[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N / 2; i++){
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                if(!graph[from].contains(to)){
                    graph[from].add(to);
                }
            }

            int ans = bfs(S);

            wr.write("#" + tc + " " + ans + "\n");
        }
        wr.flush();
        br.close();
        wr.close();
    }

    int bfs(int s){
        int[] visited = new int[size];
        Queue<Integer> q = new ArrayDeque<>();
        
        q.offer(s);
        visited[s] = 1;
        int max = 0;

        while(!q.isEmpty()){
            int c = q.poll();
            max = Math.max(max, visited[c]);

            for(int n : graph[c]){
                if(visited[n] == 0){
                    visited[n] = visited[c] + 1;
                    q.offer(n);
                }
            }
        }  

        int res = 0;
        for(int i = 1; i < size; i++){
            if(max == visited[i]){
                res = i;
            }
        }

        return res;
    }
}
