import java.util.Scanner;

public class SubSet {
    public static void main(String[] args) {
        new SubSet().solution();
    }

    int N, input[];
    boolean[] isSelected;

    void solution(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        input = new int[N];
        isSelected = new boolean[N];
        for(int i = 0; i < N; i++){
            input[i] = sc.nextInt();
        }
        generateSubSet(0);
    }

    // cnt: 현재 원소의 인덱스
    void generateSubSet(int cnt){
        // 기저 사례: 모든 원소에 대해 선택 여부를 결정했을 때
        if(cnt == N){
            // isSelected 배열을 기반으로 부분집합 출력
            for(int i = 0; i < N; i++){
                System.out.print((isSelected[i]?input[i] : "X") + " ");
            }
            System.out.println();
            return;
        }

        // 재귀 부분
        // 1. 현재 원소를 부분집합에 포함하는 경우
        isSelected[cnt] = true;
        generateSubSet(cnt + 1);

        // 2. 현재 원소를 부분집합에 포함하지 않는 경우
        isSelected[cnt] = false;
        generateSubSet(cnt + 1); // 재귀 호출 시 cnt를 1 증가시켜야 함
    }
}