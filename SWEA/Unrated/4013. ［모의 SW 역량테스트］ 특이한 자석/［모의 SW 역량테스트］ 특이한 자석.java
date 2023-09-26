import java.util.*;
import  java.io.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int test_case = Integer.parseInt(br.readLine());

        for(int t = 1; t <= test_case; t++) {
            int k = Integer.parseInt(br.readLine());
            LinkedList<Integer>[] magnet = new LinkedList[4];
            int total = 0;

            for(int i = 0; i < 4; i++) magnet[i] = new LinkedList<>();

            for(int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());

                for(int j = 0; j < 8; j++) magnet[i].add(Integer.parseInt(st.nextToken()));
            }

            for(int i = 0; i < k; i++) {
                //0번 시작, 2번 우측, 6번 좌측, 7번 끝
                st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                int[] direction = new int[4];

                num--; //인덱스 맞추기

                direction[num] = Integer.parseInt(st.nextToken());

                //좌측에서 뻗어감
                for(int j = num + 1; j < 4; j++) {
                    if(magnet[j - 1].get(2) != magnet[j].get(6)) direction[j] = direction[j - 1] * -1;
                    else break;
                }

                //우측에서 뻗어감
                for(int j = num - 1; j >= 0; j--) {
                    if(magnet[j + 1].get(6) != magnet[j].get(2)) direction[j] = direction[j + 1] * -1;
                    else break;
                }

                //회전
                for(int j = 0; j < 4; j++) {
                    if(direction[j] == 1) {
                        magnet[j].add(0, magnet[j].get(7));
                        magnet[j].remove(8);
                    }
                    else if(direction[j] == -1) {
                        magnet[j].add(magnet[j].get(0));
                        magnet[j].remove(0);
                    }
                }
            }

            //계산
            for(int i = 0; i < 4; i++) {
                if(magnet[i].get(0) == 1) total += Math.pow(2, i);
            }

            bw.write("#" + t + " " + total + "\n");
        }

        bw.close();
    }
}