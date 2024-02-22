import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        Stack<Double> stack = new Stack<>();
        double[] num = new double[n];
        double total = 0;

        for(int i = 0; i < n; i++) {
            num[i] = Double.parseDouble(br.readLine());
        }

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(ch >= 'A' && ch <= 'Z') {
                stack.push(num[ch - 'A']);
            } else {
                double num2 = stack.pop();
                double num1 = stack.pop();

                switch (ch) {
                    case '+':
                        stack.push(num1 + num2);
                        break;
                    case '-':
                        stack.push(num1 - num2);
                        break;
                    case '*':
                        stack.push(num1 * num2);
                        break;
                    case '/':
                        stack.push(num1 / num2);
                        break;
                }
            }
        }

        bw.write(String.format("%.2f" ,stack.pop()));
        bw.close();
    }
}