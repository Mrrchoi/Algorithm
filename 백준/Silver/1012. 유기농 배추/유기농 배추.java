import java.awt.*;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test_case = sc.nextInt();
        int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for(int t = 0; t < test_case; t++){
            int m = sc.nextInt();
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[][] arr = new int[n][m];

            for(int i = 0; i < k; i++){
                int c = sc.nextInt();
                int r = sc.nextInt();
                arr[r][c] = 1;
            }

            int count = 0;

            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(arr[i][j] == 0) continue;

                    count++;
                    Queue<Point> queue = new LinkedList<>();
                    arr[i][j] = 0;
                    queue.offer(new Point(i, j));

                    while(!queue.isEmpty()){
                        Point now = queue.poll();

                        for(int l = 0; l < 4; l++) {
                            int r = now.x + delta[l][0];
                            int c = now.y + delta[l][1];
                            if(r < 0 || r >= n || c < 0 || c >= m || arr[r][c] == 0) continue;

                            arr[r][c] = 0;
                            queue.offer(new Point(r, c));
                        }
                    }

                }
            }

            System.out.println(count);
        }
    }
}