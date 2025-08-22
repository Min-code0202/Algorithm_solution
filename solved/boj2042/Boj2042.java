import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj2042 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        new Boj2042().solution();
    }

    int N;
    long[] arr;
    long[] tree;

    int M, K;
    
    long init(int node, int start, int end){
        if(start == end) return tree[node] = arr[start];
        int mid = (start + end) / 2;
        return tree[node] = init(2*node, start, mid) + init(2*node + 1, mid + 1, end);
    }

    void update(int node, int start, int end, int index, long diff){
        if(index < start || index > end) return;
        tree[node] += diff;
        if(start != end){
            int mid = (start + end) / 2;
            update(node * 2, start, mid, index, diff);
            update(node * 2 + 1, mid + 1, end, index, diff);
        }
    }

    long query(int node, int start, int end, int left, int right){
        if(right < start || end < left) return 0;
        if(left <= start && end <= right) return tree[node];
        int mid = (start + end) / 2;
        return query(2*node, start, mid, left, right) + query(2*node + 1, mid + 1, end, left, right);
    }

    void solution() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new long[N + 1];
        tree = new long[4 * N];

        for(int i = 1; i <= N; i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        init(1, 1, N);
        
        for(int i = 0; i <= M + K - 1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());


            if(a == 1){
                long diff = c - arr[b];
                arr[b] = c;
                update(1, 1, N, b, diff);
            }else{
                long ans = query(1, 1, N, b, (int)c);
                wr.write(ans + "\n");
            }
        }

        wr.flush();
        br.close();
        wr.close();
    }
}
