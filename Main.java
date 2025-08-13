import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    int N;
    boolean found = false;
    String ans;

    public void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        
        solve(0, new StringBuilder());
        wr.write(ans);

        wr.flush();
        wr.close();
        br.close();
    }

    void solve(int depth, StringBuilder sb){
        if(found) return; // 순차적으로 탐색하므로 찾으면 반환
        
        if(depth == N){
            if(dislike(sb)) return;
            found = true;
            ans = sb.toString();
            return;
        }
        
        if(dislike(sb)){
            return;
        }

        for(int i = 1; i <= 3; i++){
            solve(depth + 1, sb.append(i));
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    boolean dislike(StringBuilder sb){
        for(int i = 1; i <= sb.length()/2; i++){ // i는 부분수열의 길이
            // end ~ end - i
            String subEnd = sb.substring(sb.length() - i);
            String subEnd2 = sb.substring(sb.length() - 2 * i, sb.length() - i);
            if(subEnd.equals(subEnd2))  return true;
        }


        return false;
    }
}
