import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Swea7465 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        new Swea7465().solution();
    }

    int[] parents;

    void solution() throws IOException{
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            parents = new int[N + 1];
            for(int i = 1; i < N + 1; i++){
                parents[i] = i;
            }

            while(M-- > 0){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a, b);
            }

            int ans = 0;
            for(int i = 1; i < N + 1; i++){
                if(i == parents[i]) ans++;
            }

            wr.write("#" + tc + " " + ans + "\n");
        }
        wr.flush();
        br.close();
        wr.close();
    }

    int find(int a){
        if(a == parents[a]) return a;
        return parents[a] = find(parents[a]);
    }

    void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a == b) return;
        parents[b] = a;
    }
}
