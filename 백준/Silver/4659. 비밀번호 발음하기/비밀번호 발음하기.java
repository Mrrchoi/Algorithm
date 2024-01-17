import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String vowel = "aeiou";

        while (true) {
            String password = br.readLine();

            if(password.equals("end")) {
                break;
            }

            boolean isValid = true;
            boolean hasVowel = false;
            char prev = '0';
            int count = 0;

            for (int i = 0; i < password.length(); i++) {
                char now = password.charAt(i);

                if(vowel.contains(now + "")) {
                    hasVowel = true;

                    if(vowel.contains(prev + "")) {
                        count++;

                        if(now != 'e' && now != 'o' && now == prev) {
                            isValid = false;
                            break;
                        }
                    }
                    else {
                        count = 1;
                    }
                }
                else {
                    if(!vowel.contains(prev + "")) {
                        count++;

                        if(now == prev) {
                            isValid = false;
                            break;
                        }
                    }
                    else {
                        count = 1;
                    }
                }

                if(count == 3) {
                    isValid = false;
                    break;
                }

                prev = now;
            }

            isValid &= hasVowel;


            bw.write("<" + password + "> is " + (!isValid ? "not " : "") + "acceptable.\n");
        }

        bw.close();
    }
}