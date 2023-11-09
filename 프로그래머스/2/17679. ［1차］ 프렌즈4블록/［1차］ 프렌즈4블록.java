import java.util.*;
import java.awt.Point;

class Solution {
    public int solution(int m, int n, String[] board) {
        int[][] delta = {{0, 1}, {1, 0}, {1, 1}};
        char[][] block = new char[m][n];
        int answer = 0;

        for(int i = 0; i < m; i++) {
            block[i] = board[i].toCharArray();
        }

        while (true) {
            Set<Point> set = new HashSet<>();

            for(int i = 0; i < m - 1; i++){
                loop: for(int j = 0; j < n - 1; j++) {
                    char ch = block[i][j];

                    if(ch == '@') continue;

                    for(int k = 0; k < 3; k++) {
                        if(ch != block[i + delta[k][0]][j + delta[k][1]]) {
                            continue loop;
                        }
                    }

                    set.add(new Point(i, j));

                    for(int k = 0; k < 3; k++) {
                        set.add(new Point(i + delta[k][0], j + delta[k][1]));
                    }
                }
            }

            if(set.size() == 0) break;
            else {
                answer += set.size();

                for(Point p : set) {
                    block[p.x][p.y] = '@';
                }

                for(int i = 0; i < n; i++) {
                    int idx1 = m - 1, idx2 = m - 1;
                    while(idx2 >= 0) {
                        if(block[idx2][i] == '@') {
                            idx2--;
                        }
                        else {
                            block[idx1--][i] = block[idx2--][i];
                        }

                        if(idx2 == -1) {
                            for(int j = idx1; j >= 0; j--) {
                                block[j][i] = '@';
                            }
                        }
                    }
                }
            }
        }

        return answer;
    }
}