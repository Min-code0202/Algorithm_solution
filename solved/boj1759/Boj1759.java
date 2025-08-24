
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1759 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        new Boj1759().solution();
    }

    int L, C;
    char[] arr;
    StringBuilder sb;

    void solution() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[C];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < C; i++){
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);
        sb = new StringBuilder();
        dfs(0, "");

        System.out.println(sb);
    }

    void dfs(int depth, String str){
        if(depth == C){
            if(str.length() == L && isValid(str)){
                sb.append(str).append("\n");
            }
            return;
        }

        if(str.length() > L){
            return;
        }

        dfs(depth + 1, str + arr[depth]);
        dfs(depth + 1, str);
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
