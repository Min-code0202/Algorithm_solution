import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2110 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        new Boj2110().solution();
    }

    int N, C;
    int[] x, arr;

    void solution() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        x = new int[N];
        for(int i = 0; i < N; i++){
            x[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(x);
        
        int l = 1;
        int r = x[N - 1] - x[0];
        int ans = 0;

        while(l <= r){
            int mid = (l + r) / 2;
            
            if(enable(mid)){
                ans = mid;
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }

        wr.write(ans + "\n");
        wr.flush();
        br.close();
        wr.close();
    }

    boolean enable(int d){
        int cnt = 1;
        int last = x[0];

        for(int i = 1; i < x.length; i++){
            if(x[i] - last >= d){
                cnt++;
                last = x[i];
            }
        }

        return cnt >= C;
    }
}