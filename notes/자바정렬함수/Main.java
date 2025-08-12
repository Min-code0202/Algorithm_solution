import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public void solution() throws IOException {
        int[] primitiveArr = {3, 2, 4, 1, 5};
        Arrays.sort(primitiveArr);
        System.out.println("배열 오름차순 Arrays.sort 사용");
        System.out.println(Arrays.toString(primitiveArr));
        
        Integer[] objectArr = {3, 2, 4, 1, 5};
        Arrays.sort(objectArr, Collections.reverseOrder()); // 내림차순은 원시타입 불가
        System.out.println("배열 내림차순");
        System.out.println(Arrays.toString(objectArr));

        int[] arr = {3, 2, 4, 1, 5};
        int[] sordArr = Arrays.stream(arr)
                                .boxed()
                                .sorted(Collections.reverseOrder())
                                .mapToInt(Integer::intValue)
                                .toArray();
        System.out.println("배열 오름차순 stream() 함수 사용");
        System.out.println(Arrays.toString(sordArr));

        Integer[] integers = {2, 3, 1, 5, 4};
        List<Integer> lst = Arrays.asList(integers);
        Collections.sort(lst);
        Integer[] sortedIntegers = lst.toArray(new Integer[0]);
        System.out.println(Arrays.toString(sortedIntegers));
    }

}
