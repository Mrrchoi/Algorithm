import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int test_case = Integer.parseInt(br.readLine());
        int[][] delta = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        int nr = 0, nc = 0;

        for(int t = 1; t <= test_case; t++){
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            char[][] chArr = new char[h][w];
            int r = 0, c = 0;
            int dir = 0;

            for(int i = 0; i < h; i++) chArr[i] = br.readLine().toCharArray();

            loop: for(int i = 0; i < h; i++){
                for(int j = 0; j < w; j++){
                    if(chArr[i][j] == '<' || chArr[i][j] == '>' || chArr[i][j] == 'v' || chArr[i][j] == '^'){
                        if(chArr[i][j] == '<') dir = 0;
                        else if(chArr[i][j] == '>') dir = 1;
                        else if(chArr[i][j] == 'v') dir = 2;
                        else dir = 3;

                        r = i;
                        c = j;
                        break loop;
                    }
                }
            }

            int n = Integer.parseInt(br.readLine());

            String s = br.readLine();

            for(int i = 0; i < s.length(); i++){
                char com = s.charAt(i);

                if(com == 'S'){
                    int k = 1;

                    while(true){
                        nr = r + delta[dir][0] * k;
                        nc = c + delta[dir][1] * k;

                        if(nr < 0 || nr >= h || nc < 0 || nc >= w) break;

                        if(chArr[nr][nc] == '#') break;
                        else if(chArr[nr][nc] == '*'){
                            chArr[nr][nc] = '.';
                            break;
                        }

                        k++;
                    }

                }
                else{
                    if(com == 'U'){
                        chArr[r][c] = '^';
                        dir = 3;
                    }
                    else if(com == 'D'){
                        chArr[r][c] = 'v';
                        dir = 2;
                    }
                    else if(com == 'L'){
                        chArr[r][c] = '<';
                        dir = 0;
                    }
                    else if(com == 'R'){
                        chArr[r][c] = '>';
                        dir = 1;
                    }

                    nr = r + delta[dir][0];
                    nc = c + delta[dir][1];

                    if(nr < 0 || nr >= h || nc < 0 || nc >= w) continue;

                    if(chArr[nr][nc] == '.'){
                        chArr[nr][nc] = chArr[r][c];
                        chArr[r][c] = '.';
                        r = nr;
                        c = nc;
                    }
                }
            }

            bw.write("#" + t + " ");

            for(char[] ch : chArr){
                for(char cc : ch) bw.write(cc);
                bw.newLine();
            }

        }

        bw.close();
    }
}