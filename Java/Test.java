import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Test {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

		Stack<Integer> x = new Stack<>();
		Stack<Integer> y = new Stack<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		x.add(Integer.parseInt(st.nextToken()));
		y.add(Integer.parseInt(st.nextToken()));

		st = new StringTokenizer(br.readLine());
		x.add(Integer.parseInt(st.nextToken()));
		y.add(Integer.parseInt(st.nextToken()));

		st = new StringTokenizer(br.readLine());
		x.add(Integer.parseInt(st.nextToken()));
		y.add(Integer.parseInt(st.nextToken()));

		int temp = x.pop();
		int temp2 = x.pop();
		int temp3 = x.pop();
		int pointX;
		if (temp == temp2)
			pointX = temp3;
		else if (temp2 == temp3)
			pointX = temp;
		else
			pointX = temp2;

		temp = y.pop();
		temp2 = y.pop();
		temp3 = y.pop();
		int pointY;
		if (temp == temp2)
			pointY = temp3;
		else if (temp2 == temp3)
			pointY = temp;
		else
			pointY = temp2;

		wr.write(pointX + " " + pointY);
		wr.flush();
	}

}