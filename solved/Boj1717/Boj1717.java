import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj1717 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    int n, m;
    int[] parent;

    boolean checkSame(int a, int b){
        a = find(a);
        b = find(b);
        if(a == b) return true;
        else return false;
    }

    void union(int a, int b){
        // 대표노드 찾아서 연결
        a = find(a);
        b = find(b);
        if(a != b){
            parent[b] = a;
        }
    }

    int find(int a){
        if(a == parent[a]) return a;
        return parent[a] = find(parent[a]); // 대표노드 연결
    }

    public void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        for(int i = 0; i < n + 1; i++){ // 대표노드 초기화
            parent[i] = i;
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(op == 0){
                union(a, b);
            }else{
                boolean result = checkSame(a, b);
                if(result){
                    wr.write("YES\n");
                }else{
                    wr.write("NO\n");
                }
            }
        }

        wr.flush();
        wr.close();
        br.close();
    }

    public static void main(String[] args) throws IOException {
        new Boj1717().solution();
    }
}
