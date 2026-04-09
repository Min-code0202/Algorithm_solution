import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj15681 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        new Boj15681().solution();
    }

    int N, R, Q;
    ArrayList<Integer> graph[];
    ArrayList<Integer> tree[];
    int[] size;

    void makeTree(int cur, int parent){
        for(int node : graph[cur]){
            if(node != parent){
                tree[cur].add(node);
                makeTree(node, cur);
            }
        }
    }

    int countSubTreeNodes(int cur){
        size[cur] = 1;
        for(int node : tree[cur]){
            size[cur] += countSubTreeNodes(node);
        }
        return size[cur];
    }

    void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());        
        R = Integer.parseInt(st.nextToken());        
        Q = Integer.parseInt(st.nextToken());       
        
        size = new int[N + 1];
        graph = new ArrayList[N + 1];
        tree = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
            tree[i] = new ArrayList<>();
        }

        for(int i = 0; i < N - 1; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }
            
        makeTree(R, -1);
        countSubTreeNodes(R);

        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < Q; t++){
            int U = Integer.parseInt(br.readLine());
            sb.append(size[U]).append("\n");
        }
        System.out.println(sb.toString());

        br.close();
    }
}
