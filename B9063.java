import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.stream.Stream;

public class B9063 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());    // 점의 개수
        int[] x = new int[N];   // x 좌표
        int[] y = new int[N];   // y 좌표
        
        
        // 점 개수만큼 입력 받음
        for(int i = 0; i < N; i++){
            int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            x[i] = arr[0];
            y[i] = arr[1];
        }

        // x 좌표와 y 좌표 오름차순 정렬
        Arrays.sort(x);
        Arrays.sort(y);
        
        int square = (x[N - 1] - x[0]) * (y[N - 1] - y[0]);

        wr.write(Integer.toString(square));
        wr.flush();

        br.close();
        wr.close();
    }
}
