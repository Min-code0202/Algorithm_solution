import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        new Main().solution();
    }

    void solution() throws IOException{
        int M = Integer.parseInt(br.readLine());
        int S = 0;
        StringTokenizer st;
        while(M-- >0){
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if(order.equals("all")){
                S = (1 << 21) - 1;
            }else if(order.equals("empty")){
                S = 0;
            }else{
                int n = Integer.parseInt(st.nextToken());
                if(order.equals("add")){
                    S |= (1 << n);
                }else if(order.equals("remove")){
                    S &= ~(1 << n);
                }else if(order.equals("check")){
                    wr.write(((S & (1 << n)) != 0 ? 1 : 0) + "\n");
                }else if(order.equals("toggle")){
                    S ^= (1 << n);
                }
            }
        }

        wr.flush();
        br.close();
        wr.close();
    }
}