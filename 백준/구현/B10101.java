import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class B10101 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr = new int[3]; // 세 각을 입력받을 배열

    static String tringle() {
        int sum = Arrays.stream(arr).sum(); // 세 각의 합

        if (sum == 180) {
            if (arr[0] == arr[1] && arr[1] == arr[2])
                return "Equilateral";
            if (arr[0] == arr[1] || arr[1] == arr[2] || arr[2] == arr[0])
                return "Isosceles";
            if (arr[0] != arr[1] || arr[1] != arr[2])
                return "Scalene";
        } else {
            return "Error";
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 3; i++)
            arr[i] = Integer.parseInt(br.readLine());

        wr.write(tringle());
        wr.flush();

        br.close();
        wr.close();
    }
}
