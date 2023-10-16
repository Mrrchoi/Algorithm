import java.util.*;

class Solution {
    public static long max = 0;
    public static void calculate(String expression, char[] operator) {
        StringTokenizer st = new StringTokenizer(expression, "-|+|*", true);
        Map<Character, Integer> map = new HashMap<>();
        Stack<Long> number = new Stack<>();
        Stack<Character> op = new Stack<>();
        int len = st.countTokens();

        for(int i = 0; i < 3; i++) map.put(operator[i], i);

        for(int i = 0; i < len; i++) {
            String s = st.nextToken();

            if(i % 2 == 0) {
                number.push(Long.parseLong(s));
                continue;
            }

            while(!op.isEmpty() && map.get(op.peek()) >= map.get(s.charAt(0))) {
                char opr = op.pop();
                long number2 = number.pop();
                long number1 = number.pop();

                switch (opr){
                    case '+':
                        number.push(number1 + number2);
                        break;
                    case '-':
                        number.push(number1 - number2);
                        break;
                    case '*':
                        number.push(number1 * number2);
                        break;
                    case '/':
                        number.push(number1 / number2);
                        break;
                }
            }

            op.push(s.charAt(0));
        }

        while(!op.isEmpty()) {
            char opr = op.pop();
            long number2 = number.pop();
            long number1 = number.pop();

            switch (opr){
                case '+':
                    number.push(number1 + number2);
                    break;
                case '-':
                    number.push(number1 - number2);
                    break;
                case '*':
                    number.push(number1 * number2);
                    break;
                case '/':
                    number.push(number1 / number2);
                    break;
            }
        }

        max = Math.max(max, Math.abs(number.pop()));
    }
    public static void permutation(String expression, char[] operator, int depth) {
        if(depth == 3) {
            calculate(expression, operator);
            return;
        }

        for(int i = depth; i < 3; i++) {
            swap(operator, i, depth);
            permutation(expression, operator, depth + 1);
            swap(operator, i, depth);
        }

    }
    public static void swap(char[] chArr, int idx1, int idx2) {
        char tmp = chArr[idx1];
        chArr[idx1] = chArr[idx2];
        chArr[idx2] = tmp;
    }
    public static long solution(String expression){
        char[] operation = {'+', '-', '*'};

        permutation(expression, operation, 0);

        return max;
    }
}