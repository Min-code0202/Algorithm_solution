
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj1654{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        new Boj1654().solution();
    }

    void solution() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        Long[] LAN = new Long[K];
        long max = 0;
        long mid = 0;
        long min = 0;
        for(int i = 0; i < K; i++){
            LAN[i] = Long.parseLong(br.readLine());
                if(max < LAN[i])
                    max = LAN[i];
        }
        max++;
        while(min < max){
            mid = (max + min)/2;
            long cnt = 0;
            for(int i = 0; i < LAN.length; i++){
                cnt += LAN[i] / mid;
            }

            if(cnt < N) max = mid;
            else min = mid + 1;
        }

        wr.write((min - 1) + "\n");
        wr.flush();
        br.close();
        wr.close();
    }
}