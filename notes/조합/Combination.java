import java.util.Arrays;
import java.util.Scanner;

public class Combination {
    public static void main(String[] args) {
        new Combination().solution();
    }

    int N, numbers[], totalCnt = 0;
    boolean[] isSelected;

    void solution(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int M = sc.nextInt();

        numbers = new int[N];

        switch (M) {
		case 1:  // 중복 순열
			dice1(0);
			break;
		case 2:  // 순열 
			isSelected = new boolean[7]; // 주사위 눈 1~6
			dice2(0);
			break;
		case 3: // 중복 조합 
			dice3(0,1);
			break;
		case 4: // 조합 
            isSelected = new boolean[7]; // 주사위 눈 1~6
			dice4(0, 1);
			break;
		default:
			System.out.println("던지기 모드값이 잘못되었습니다.(1~4 모드값 입력 필요!)");
			break;
		}
		System.out.println("모든 경우의 수 :"+totalCnt);
    }

    void dice1(int cnt){
        if(cnt == N){
            totalCnt++;
            System.out.println(Arrays.toString(numbers));
            return;
        }

        for(int i = 1; i <= 6; i++){
            numbers[cnt] = i;
            dice1(cnt + 1);
        }
    }

    void dice2(int cnt){
        if(cnt == N){
            totalCnt++;
            System.out.println(Arrays.toString(numbers));
            return;
        }

        for(int i = 1; i <= 6; i++){
            if(isSelected[i]) continue;
            isSelected[i] = true;
            numbers[cnt] = i;
            dice2(cnt + 1);
            isSelected[i] = false;
        }
    }

    void dice3(int cnt, int start){
        if(cnt == N){
            totalCnt++;
            System.out.println(Arrays.toString(numbers));
            return;
        }

        for(int i = start; i <= 6; i++){
            numbers[cnt] = i;
            dice3(cnt + 1, i);
        }
    }

    void dice4(int cnt, int start){
        if(cnt == N){
            totalCnt++;
            System.out.println(Arrays.toString(numbers));
            return;
        }

        for(int i = start; i <= 6; i++){
            if(isSelected[i]) continue;
            numbers[cnt] = i;
            isSelected[i] = true;
            dice4(cnt + 1, i);
            isSelected[i] = false;
        }
        
        // 이렇게도 가능
        // for(int i = start; i <= 6; i++){
        //     numbers[cnt] = i;
        //     dice4(cnt + 1, i + 1);
        // }
    }
}
