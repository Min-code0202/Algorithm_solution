import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1759_ver2 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int L, C;
    char[] arr;
    StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        new Boj1759_ver2().solution();
    }

    void solution() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);
        dfs(0, 0, "");
        System.out.print(sb);
    }

    void dfs(int depth, int start, String str) {
        if (depth == L) {
            if (isValid(str)) {
                sb.append(str).append("\n");
            }
            return;
        }

        for (int i = start; i < C; i++) {
            dfs(depth + 1, i + 1, str + arr[i]);
        }
    }

    boolean isValid(String str) {
        int vowel = 0, consonant = 0;
        for (char ch : str.toCharArray()) {
            if ("aeiou".indexOf(ch) >= 0) vowel++;
            else consonant++;
        }
        return (vowel >= 1 && consonant >= 2);
    }
}
