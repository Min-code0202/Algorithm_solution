
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj11505 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        new Boj11505().solution();
    }

    final long MOD = 1_000_000_007L;
    int N, M, K;
    long[] arr;
    long[] tree;

    long init(int node, int s, int e){
        if(s == e) return tree[node] = arr[s];

        int mid = (s + e) / 2;
        return tree[node] = init(node * 2, s, mid) * init(node * 2 + 1, mid + 1, e) %  MOD;
    }

    long update(int node, int s, int e, int idx, long val){
        if(idx < s || idx > e) return tree[node];
        if(s == e) return tree[node] = val;
        int mid = (s + e)/2;
        return tree[node] = (update(node * 2, s, mid, idx, val) * 
                                update(node * 2 + 1, mid + 1, e, idx, val)) % 
                                MOD;
    }

    long query(int node, int s, int e, int l, int r){
        if(l > e || r < s) return 1;
        if(l <= s && e <= r) return tree[node];
        int mid = (s + e)/2;
        return (query(node * 2, s, mid, l, r) * 
                query(node * 2 + 1, mid + 1, e, l, r)) % 
                MOD;
    }

    void solution() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new long[N + 1];
        tree = new long[4 * N];

        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        init(1, 1, N);

        for(int i = 0; i < M + K; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(a == 1){
                arr[b] = c;
                update(1, 1, N, b, c);
            } 
            else wr.write(query(1, 1, N, b, (int)c) + "\n");
        }

        wr.flush();
        br.close();
        wr.close();
    }
}
