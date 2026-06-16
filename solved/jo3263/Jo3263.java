import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Jo3263 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        new Jo3263().solution();
    }

    int N;
    long[] arr;

    void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        long total = 0;

        for(int i = 0; i < N; i++){
            arr[i] = Long.parseLong(st.nextToken());
            total += arr[i];
        }

        long maxCur = arr[0];
        long maxSum = arr[0];

        long minCur = arr[0];
        long minSum = arr[0];

        for(int i = 1; i < N; i++){
            maxCur = Math.max(arr[i], maxCur + arr[i]);
            maxSum = Math.max(maxSum, maxCur);

            minCur = Math.min(arr[i], minCur + arr[i]);
            minSum = Math.min(minSum, minCur);
        }

        if(maxSum < 0){
            System.out.println(maxSum);
        }else{
            System.out.println(Math.max(maxSum, total - minSum));
        }
    }
}