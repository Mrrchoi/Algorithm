import java.io.*;

public class Main {
    public static boolean[][] visit;
    public static int[][] delta = {{-1, -1}, {-1, 0}, {-1, 1}};
    public static int answer = 0;
    public static void check_queen(int count, int r){
        if(count == visit.length) {
            answer++;
            return;
        }

        loop: for(int i = 0; i < visit.length; i++){
            for(int k = 0; k < 3; k++){
                for(int l = 0;; l++){
                    if(r + delta[k][0] * l < 0 || r + delta[k][0] * l >= visit.length || i + delta[k][1] * l < 0 || i + delta[k][1] * l >= visit.length) break;

                    if(visit[r + delta[k][0] * l][i + delta[k][1] * l] == true) continue loop;
                }
            }

            visit[r][i] = true;
            check_queen(count + 1, r + 1);
            visit[r][i] = false;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n =Integer.parseInt(br.readLine());
        visit = new boolean[n][n];

        check_queen(0, 0);

        bw.write("" + answer);
        bw.close();
    }
}