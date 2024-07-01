import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.Stream;

public class B13241 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    Long getGCD(Long num1, Long num2) {
        if (num1 % num2 == 0)
            return num2;
        return getGCD(num2, num1 % num2);
    }

    public B13241() throws IOException {
        Long[] arr = Stream.of(br.readLine().split(" ")).map(Long::parseLong).toArray(Long[]::new);
        Long gcd = getGCD(arr[0], arr[1]); // 유클리드 호제법을 사용해 최대공약수 반환
        // 최소공배수: (a * b)/gcd
        Long LCM = (arr[0] * arr[1]) / gcd;
        wr.write(Long.toString(LCM));

        wr.flush();
        br.close();
        wr.close();
    }

    public static void main(String[] args) throws IOException {
        new B13241();
    }
}
