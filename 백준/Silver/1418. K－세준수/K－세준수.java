import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        boolean[] composite = new boolean[n + 1];

        composite[0] = composite[1] = true;

        for(int i = 2; i <= n; i++) {
            if(!composite[i]) {
                for(int j = 2 * i; j <= n; j += i) {
                    composite[j] = true;
                }
            }
        }

        int count = 1;

        loop: for(int i = 2; i <= n; i++) {
            if(composite[i]) {
                int maxPrime = 0;

                for(int j = 1; j <= Math.sqrt(n); j++) {
                    if(i % j == 0) {
                        if(!composite[j]) {
                            maxPrime = Math.max(maxPrime, j);
                        }

                        if(!composite[i / j]) {
                            maxPrime = Math.max(maxPrime, i / j);
                        }

                        if(maxPrime > k) {
                            continue loop;
                        }
                    }
                }
            }
            else if(i > k) {
                continue;
            }

            count++;
        }

        bw.write(count + "");
        bw.close();
    }
}