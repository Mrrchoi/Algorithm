import java.util.*;
import java.io.*;

public class Main {
    public static int binarySearch(int[] lis, int start, int end, int target) {
        while (start < end) {
            int mid = (start + end) / 2;

            if(lis[mid] >= target) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }

        return end;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> indexList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[500001];
        int[] lis = new int[n];
        int[] sequence = new int[n];
        int idx = 0;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            arr[number] = value;

            indexList.add(number);
        }

        indexList.sort(Comparator.naturalOrder());

        lis[0] = arr[indexList.get(0)];

        for(int i = 1; i < n; i++) {
            if(lis[idx] < arr[indexList.get(i)]) {
                lis[++idx] = arr[indexList.get(i)];
                sequence[i] = idx;
            }
            else {
                int new_idx = binarySearch(lis, 0, idx, arr[indexList.get(i)]);
                lis[new_idx] = arr[indexList.get(i)];
                sequence[i] = new_idx;
            }
        }

        bw.write((n - idx - 1) + "\n");

        int len = idx, last = Integer.MAX_VALUE;

        for(int i = n - 1; i >= 0; i--) {
            if(len == sequence[i] && arr[indexList.get(i)] < last) {
                last = arr[indexList.get(i)];
                len--;
            }
            else {
                stack.push(indexList.get(i));
            }
        }

        while (!stack.isEmpty()) {
            bw.write(stack.pop() + "\n");
        }

        bw.close();
    }
}