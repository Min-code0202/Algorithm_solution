import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Swea1952 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        new Swea1952().solution();
    }


    int day, month, third, year, plan[];
    int ans = Integer.MAX_VALUE;

    void solution() throws IOException{
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            day = Integer.parseInt(st.nextToken());
            month = Integer.parseInt(st.nextToken());
            third = Integer.parseInt(st.nextToken());
            year = Integer.parseInt(st.nextToken());

            plan = new int[12];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 12; i++){
                plan[i] = Integer.parseInt(st.nextToken());
            }

            int yearCost = year;
            ans = yearCost;
            solve(0, 0, 0);

            wr.write("#" + tc + " " + ans + "\n");
        }

        wr.flush();
        br.close();
        wr.close();
    }

    void solve(int depth, int cost, int remain){
        if(cost >= ans) return;
        if(depth == 12){
            ans = Math.min(ans, cost);
            return;
        }

        if(remain > 0){
            solve(depth + 1, cost, remain - 1);
        }else{
            if(plan[depth] == 0){
                solve(depth + 1, cost, remain);
            }else{
                solve(depth + 1, cost + plan[depth] * day, 0);
                solve(depth + 1, cost + month, 0);
                solve(depth + 1, cost + third, 2);
            }
        }

    }
}
