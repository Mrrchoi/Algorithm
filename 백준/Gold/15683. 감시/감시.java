import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main {
    public static int min = Integer.MAX_VALUE;
    public static void calculator(int[][] office, ArrayList<Point> cctv, int idx) {
        if(idx == cctv.size()){
            int count = 0;

            for(int i = 0; i < office.length; i++) {
                for(int j = 0; j < office[i].length; j++) {
                    if(office[i][j] == 0) count++;
                }
            }

            min = Math.min(min, count);
            return;
        }

        Point p = cctv.get(idx);
        int[][] delta = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        switch (office[p.x][p.y]) {
            case 1:
                for(int i = 0; i < delta.length; i++) {
                    int nr = p.x;
                    int nc = p.y;

                    while(true) {
                        nr += delta[i][0];
                        nc += delta[i][1];

                        if(nr < 0 || nr >= office.length || nc < 0 || nc >= office[0].length || office[nr][nc] == 6) break;

                        if(office[nr][nc] <= 0) office[nr][nc] -= 1;
                    }

                    calculator(office, cctv, idx + 1);

                    nr = p.x;
                    nc = p.y;

                    while(true) {
                        nr += delta[i][0];
                        nc += delta[i][1];

                        if(nr < 0 || nr >= office.length || nc < 0 || nc >= office[0].length || office[nr][nc] == 6) break;

                        if(office[nr][nc] < 0) office[nr][nc] += 1;
                    }
                }

                break;
            case 2:
                for(int i = 0; i < 2; i++) {
                    for(int j = 0; j < 3; j += 2) {
                        int nr = p.x;
                        int nc = p.y;

                        while(true){
                            nr += delta[i + j][0];
                            nc += delta[i + j][1];

                            if(nr < 0 || nr >= office.length || nc < 0 || nc >= office[0].length || office[nr][nc] == 6) break;

                            if(office[nr][nc] <= 0) office[nr][nc] -= 1;
                        }
                    }

                    calculator(office, cctv, idx + 1);

                    for(int j = 0; j < 3; j += 2) {
                        int nr = p.x;
                        int nc = p.y;

                        while(true){
                            nr += delta[i + j][0];
                            nc += delta[i + j][1];

                            if(nr < 0 || nr >= office.length || nc < 0 || nc >= office[0].length || office[nr][nc] == 6) break;

                            if(office[nr][nc] < 0) office[nr][nc] += 1;
                        }
                    }
                }

                break;
            case 3:
                for(int i = 0; i < 4; i++) {
                    for(int j = 0; j < 2; j++) {
                        int nr = p.x;
                        int nc = p.y;

                        while(true) {
                            nr += delta[(i + j) % 4][0];
                            nc += delta[(i + j) % 4][1];

                            if(nr < 0 || nr >= office.length || nc < 0 || nc >= office[0].length || office[nr][nc] == 6) break;

                            if(office[nr][nc] <= 0) office[nr][nc] -= 1;
                        }
                    }

                    calculator(office, cctv, idx + 1);

                    for(int j = 0; j < 2; j++) {
                        int nr = p.x;
                        int nc = p.y;

                        while(true) {
                            nr += delta[(i + j) % 4][0];
                            nc += delta[(i + j) % 4][1];

                            if(nr < 0 || nr >= office.length || nc < 0 || nc >= office[0].length || office[nr][nc] == 6) break;

                            if(office[nr][nc] < 0) office[nr][nc] += 1;
                        }
                    }
                }

                break;
            case 4:
                for(int i = 0; i < 4; i++) {
                    for(int j = 0; j < 3; j++) {
                        int nr = p.x;
                        int nc = p.y;

                        while(true) {
                            nr += delta[(i + j) % 4][0];
                            nc += delta[(i + j) % 4][1];

                            if(nr < 0 || nr >= office.length || nc < 0 || nc >= office[0].length || office[nr][nc] == 6) break;

                            if(office[nr][nc] <= 0) office[nr][nc] -= 1;
                        }
                    }

                    calculator(office, cctv, idx + 1);

                    for(int j = 0; j < 3; j++) {
                        int nr = p.x;
                        int nc = p.y;

                        while(true) {
                            nr += delta[(i + j) % 4][0];
                            nc += delta[(i + j) % 4][1];

                            if(nr < 0 || nr >= office.length || nc < 0 || nc >= office[0].length || office[nr][nc] == 6) break;

                            if(office[nr][nc] < 0) office[nr][nc] += 1;
                        }
                    }
                }

                break;
            case 5:
                for(int i = 0; i < delta.length; i++) {
                    int nr = p.x;
                    int nc = p.y;

                    while(true) {
                        nr += delta[i][0];
                        nc += delta[i][1];

                        if(nr < 0 || nr >= office.length || nc < 0 || nc >= office[0].length || office[nr][nc] == 6) break;

                        if(office[nr][nc] <= 0) office[nr][nc] -= 1;
                    }
                }

                calculator(office, cctv, idx + 1);

                for(int i = 0; i < delta.length; i++) {
                    int nr = p.x;
                    int nc = p.y;

                    while(true) {
                        nr += delta[i][0];
                        nc += delta[i][1];

                        if(nr < 0 || nr >= office.length || nc < 0 || nc >= office[0].length || office[nr][nc] == 6) break;

                        if(office[nr][nc] < 0) office[nr][nc] += 1;
                    }
                }

                break;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] office = new int[n][m];
        ArrayList<Point> cctv = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                office[i][j] = Integer.parseInt(st.nextToken());
                if(office[i][j] % 6 != 0) cctv.add(new Point(i, j));
            }
        }

        calculator(office, cctv, 0);

        bw.write(min + "");
        bw.close();
    }
}