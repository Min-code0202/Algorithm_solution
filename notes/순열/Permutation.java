import java.util.Arrays;

public class Permutation {
    public static void main(String[] args) {
        new Permutation().solution();
    }

    int N = 3, R = 3;
    int[] numbers;
    boolean[] isSelected;

    void solution(){
        numbers = new int[R];
        isSelected = new boolean[N + 1];

        permutation(0);
    }

    void permutation(int cnt){
        if(cnt == R){
            System.out.println(Arrays.toString(numbers));
            return;
        }
        // 가능한 모든 수를 해당 자리에 시도
        for(int i = 1; i <= N; i++){
            if(isSelected[i]) continue;
            numbers[cnt] = i;
            isSelected[i] = true;
            permutation(cnt + 1);
            isSelected[i] = false;
        }
    }
}
