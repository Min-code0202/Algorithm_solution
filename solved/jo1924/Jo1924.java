import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Jo1924 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        new Jo1924().solution();
    }

    void solution() throws IOException {
        char[] arr = br.readLine().toCharArray();
        int n = arr.length;

        char[] ch = new char[n];
        int[] cnt = new int[n];

        int size = 0;
        int i = 0;

        while (i < n) {
            char cur = arr[i];
            int count = 0;

            while (i < n && arr[i] == cur) {
                count++;
                i++;
            }

            ch[size] = cur;
            cnt[size] = count;
            size++;
        }

        int answer = 0;

        for (i = 0; i + 2 < size; i++) {
            if (ch[i] == 'J' && ch[i + 1] == 'O' && ch[i + 2] == 'I') {
                int j = cnt[i];
                int o = cnt[i + 1];
                int ii = cnt[i + 2];

                if (j >= o && ii >= o) {
                    answer = Math.max(answer, o);
                }
            }
        }

        System.out.println(answer);
    }
}