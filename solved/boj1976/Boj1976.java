import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj1976 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        new Boj1976().solution();
    }

    int N, M;
    ArrayList<Integer>[] graph;
    int[] parents;

    void solution() throws IOException{
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        parents = new int[N + 1];
        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
            parents[i] = i;
        } 
        
        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                int v = Integer.parseInt(st.nextToken());
                if(v == 1){
                    graph[i].add(j);
                    graph[j].add(i);
                    union(i, j);
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int prev = find(Integer.parseInt(st.nextToken()));
        String ans = "YES";
        for(int i = 1; i < M; i++){
            int num = Integer.parseInt(st.nextToken());
            num = find(num);
            if(prev != num){
                ans = "NO";
            }
            prev = num;
        }
        wr.write(ans + "\n");
        wr.flush();
        br.close();
        wr.close();
    }

    int find(int a){
        if(parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }

    boolean union(int a, int b){
        a = find(a);
        b = find(b);
        if(a == b) return false;
        parents[b] = a;
        return true;
    }
}
