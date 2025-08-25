import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Swea3289 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        new Swea3289().solution();
    }

    int[] parents;

    void solution() throws IOException{
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            parents = new int[n + 1];
            for(int i = 1; i < n + 1; i++){
                parents[i] = i;
            }

            wr.write("#" + tc + " ");
            while(m-- >0){
                st = new StringTokenizer(br.readLine());
                int op = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if(op == 0){
                    union(a, b);
                }else{
                    String ans = "0";
                    ans = (find(a) == find(b)) ? "1" : "0";
                    wr.write(ans);
                }
            }
            wr.write("\n");
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
