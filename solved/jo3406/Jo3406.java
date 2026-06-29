import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Jo3406 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        new Jo3406().solution();
    }

    int N, K;
    int[] elec;

    void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        elec = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            elec[i] = Integer.parseInt(st.nextToken());
        }

        int i = 0;
        int cnt = 0;

        while(i < N){
            int left = Math.max(0, i - K + 1);
            int right = Math.min(N - 1, i + K - 1);

            int pos = -1;
            
            for(int p = right; p >= left; p--){
                if(elec[p] == 1){
                    pos = p;
                    break;
                }
            }

            if(pos == -1){
                System.out.println(-1);
                return;
            }

            cnt++;
            i = pos + K;
        }

        System.out.println(cnt);
    }
}