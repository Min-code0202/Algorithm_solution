import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Boj16139 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        new Boj16139().solution();
    }

    void solution() throws IOException{
        char[] S = br.readLine().toCharArray();
        int q = Integer.parseInt(br.readLine());
        int n = S.length;
        int[][] prefix = new int[26][n + 1];

        for(int i = 1; i <= n; i++){
            for(int j = 0; j < 26; j++){
                prefix[j][i] = prefix[j][i - 1];
            }
            prefix[S[i - 1] - 'a'][i]++;
        }

        while(q-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            int ans = prefix[a.charAt(0) - 'a'][r + 1] - prefix[a.charAt(0) - 'a'][l];
            wr.write(ans + "\n");
        }
        wr.flush();
        br.close();
        wr.close();
    }
}
