import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj1931 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        new Boj1931().solution();
    }

    void solution() throws IOException{
        int N = Integer.parseInt(br.readLine());
        List<int[]> meeting = new ArrayList<>();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            meeting.add(new int[]{s, e});
        }

        Collections.sort(meeting, (a, b) -> {
            if(a[1] == b[1]) return a[0] - b[0];
            return a[1] - b[1];
        });
        
        int ans = 0;
        int prev = 0;
        for(int[] arr : meeting){
            if(prev <= arr[0]){
                ans++;
                prev = arr[1];
            }
        }

        wr.write(ans + "\n");

        wr.flush();
        br.close();
        wr.close();
    }
}
