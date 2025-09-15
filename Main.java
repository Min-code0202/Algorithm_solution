import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    int N;
    int[] arr;
    int[] sub;

    void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        sub = new int[N];
        Arrays.fill(sub, 1);
        
        int maxLen = 1;
        for(int i = 1; i < N; i++){
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i]){
                    sub[i] = Math.max(sub[i], sub[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, sub[i]);
        }
        System.out.println(maxLen);
    }
}
