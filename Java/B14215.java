import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.stream.Stream;

public class B14215 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public B14215() throws IOException {
        int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);

        if (arr[0] + arr[1] > arr[2]) {
            int sum = Arrays.stream(arr).sum();
            wr.write(Integer.toString(sum));
        } else {
            int sum = 2 * (arr[0] + arr[1]) - 1;
            wr.write(Integer.toString(sum));
        }
        wr.flush();
        
        br.close();
        wr.close();
    }

    public static void main(String[] args) throws IOException {
        new B14215();
    }
}
