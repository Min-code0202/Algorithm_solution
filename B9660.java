import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B9660 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public B9660() throws IOException {
        long n = Long.parseLong(br.readLine());
        if (n % 7 == 0 || n % 7 == 2)
            wr.write("CY");
        else
            wr.write("SK");

        wr.flush();
        br.close();
        wr.close();
    }

    public static void main(String[] args) throws IOException {
        new B9660();
    }
}
